package com.dandan.aop;

import com.dandan.aop.LogAspect;
import com.dandan.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @date：2020/10/27
 * @author：suchao
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.dandan.aop")
public class MainConfigOfAOP {

//    //业务逻辑类
//    @Bean
//    public MathCalculator mathCalculator(){
//        return new MathCalculator();
//    }
//
//    @Bean
//    public LogAspect logAspect(){
//        return new LogAspect();
//    }

}
