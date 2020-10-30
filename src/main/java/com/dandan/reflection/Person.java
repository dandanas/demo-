package com.dandan.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date：2020/10/29
 * @author：suchao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private String name;
    public Integer  age;
    int id;

    @MyAnnotation
    public void show() {
        System.out.println("我是个废物");
    }

    private String showNation(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }

    private Person(String name){
        this.name = name;
    }

    public Person(String name,Integer age){
        this.name = name;
        this.age  =age;
    }

    public String display(String interesting){
        return interesting;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }
}
