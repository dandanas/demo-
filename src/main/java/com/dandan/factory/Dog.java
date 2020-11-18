package com.dandan.factory;

/**
 * @date：2020/11/16
 * @author：suchao
 */
public class Dog implements Animal{
    @Override
    public void eat() {
        System.out.println("骨头");
    }
}
