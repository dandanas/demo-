package com.dandan.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;

/**
 * @Author: dandan
 * @Date: 2020/10/28 10:23
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Cat extends Animal{

    private Integer legs;

    public Cat(){
    }

    public Cat(String type, String name, Integer age, Integer legs){
        super(type, name, age);
        this.legs = legs;
    }

    @Override
    public boolean equals(Object otherObject){
        //父类重写过equals, 所以先比较用父类的比较
        if(!(super.equals(otherObject))){
            return false;
        }
        //引用同一个对象
        if(this == otherObject){
            return true;
        }
        if(otherObject == null){
            return false;
        }
        if(getClass() != otherObject.getClass()){
            return false;
        }
        Cat other = (Cat) otherObject;
        return this.legs.equals(other.getLegs());
    }

}
