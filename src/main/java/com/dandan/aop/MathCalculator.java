package com.dandan.aop;


import org.springframework.stereotype.Component;

/**
 * @date：2020/10/27
 * @author：suchao
 */
@Component
public class MathCalculator {

    public int div(int i ,int j){
        return i/j;
    }
}
