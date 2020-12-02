package com.dandan.validation;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @date：2020/11/29
 * @author：suchao
 * 参数校验相关配置
 */
public class ValidationConfiguration {

    @Configuration
    public class ValidatorConfiguration {
        /**
         * 普通模式(会校验完所有的属性，然后返回所有的验证失败信息)
         * 快速失败返回模式
         * 　　快速失败返回模式(只要有一个验证失败，则返回)
         * failFast：true  快速失败返回模式    false 普通模式
         * @return
         */
        @Bean
        public Validator validator(){
            ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
                    .configure()
                    .addProperty( "hibernate.validator.fail_fast", "true" )
                    .buildValidatorFactory();
            Validator validator = validatorFactory.getValidator();


            return validator;
        }

        @Bean
        public MethodValidationPostProcessor methodValidationPostProcessor() {
            MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();  /**设置validator模式为快速失败返回*/
            postProcessor.setValidator(validator());
            return postProcessor;
        }

    }
}
