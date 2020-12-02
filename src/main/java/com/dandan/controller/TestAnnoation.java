package com.dandan.controller;

import com.dandan.logAop.TimeConsuming;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @date：2020/12/2
 * @author：suchao
 */
@Component
public class TestAnnoation {


    @TimeConsuming(fullMsg = true)
    public String printDate(){
        System.out.println(new Date().toString());
        for (int i = 0; i <100 ; i++) {
            System.out.println(i);
        }
        return "计算成功";
    }
}
