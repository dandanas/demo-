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

    @Override
    public boolean equals(Object otherObject){
        //判断是否引用同一个对象
        if(this == otherObject){
            return true;
        }
        //比较对象不能为空
        if(otherObject == null){
            return false;
        }
        //只有当两个类属于同一个类时，才有可能相等
        if(getClass() != otherObject.getClass()){
            return false;
        }
        Animal other = (Animal) otherObject;
        //比较类下面的域是否都相等，基础类型用 == 对象用 equals
        return this.age.equals(other.getAge()) && this.name == other.getName() && this.type == other.getType();
    }

}
