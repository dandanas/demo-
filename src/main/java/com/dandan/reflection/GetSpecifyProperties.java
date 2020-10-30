package com.dandan.reflection;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 获取运行时类的指定属性，方法，构造器
 * @see com.dandan.reflection.ReflectionTest
 * @date：2020/10/30
 * @author：suchao
 */
public class GetSpecifyProperties {


    /**
     * 如何操作运行时类的指定属性
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException, InstantiationException {

        Class<Person> aClass = Person.class;

        //创建运行时类的对象
        Person person = aClass.newInstance();

        /**
         * 获取运行时类的指定变量名的属性
         *  private String name;
         */
        Field name = aClass.getDeclaredField("name");

        //保证当前属性是可访问的
        name.setAccessible(true);
        //设置指定对象的属性值
        name.set(person,"sd");
        System.out.println(name.get(person));

        //调用方法，构造器同理


    }
}
