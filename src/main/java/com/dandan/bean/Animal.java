package com.dandan.bean;

import lombok.Data;

/**
 * @Author: dandan
 * @Date: 2020/10/28 10:21
 */

@Data
public class Animal {


    public String type;

    private String name;

    public Integer age;

    public int number;

    public Animal(){
    }

    public Animal(String type, String name, Integer age){
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public void Test(){
        System.out.println("Test");
        System.out.println("this method has been used");
    }


}
