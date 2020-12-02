package com.dandan.demo;

import com.dandan.logAop.TimeConsuming;
import org.springframework.stereotype.Component;

/**
 * @date：2020/12/2
 * @author：suchao
 */
@Component
public class Review {

    @TimeConsuming
    public String testTimeConsuming(String a, String b) {
        for (int i = 0; i < 100; i++) {
            System.out.print("");
        }
        return "OK2";
    }
}
