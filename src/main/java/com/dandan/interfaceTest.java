package com.dandan;

/**
 * @Author: dandan
 * @Date: 2020/11/3 16:40
 */

@FunctionalInterface
public interface interfaceTest {

    default String test() {
        return "dandan";
    }

    abstract int test1(Integer a);

    static String testStatic(){
        return "static method";
    }
}
