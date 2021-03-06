package com.dandan.aop;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @date：2020/10/27
 * @author：suchao
 */
public class  IOCTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        String[] beanNamesForType = applicationContext.getBeanNamesForType(MathCalculator.class);
        for (String d :beanNamesForType){
            System.out.println( d);
        }
        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,1);
    }
}
