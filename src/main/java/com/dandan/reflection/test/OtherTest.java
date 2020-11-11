package com.dandan.reflection.test;

import com.dandan.reflection.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @date：2020/10/29
 * @author：suchao
 */
public class OtherTest {

    @Test
    public void test(){
        Class<Person> personClass = Person.class;
        //当前运行时类的public的构造方法
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor constructor : constructors){
            System.out.println(constructor);
        }
        System.out.println("hhhh");

        //当前运行时类所有的的构造方法
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors){
            System.out.println(constructor);
        }

    }
}
