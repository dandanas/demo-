package com.dandan.reflection;

import org.junit.Test;

import java.util.Random;

/**
 * 通过反射创建对应的运行时类的对象
 * @date：2020/10/29
 * @author：suchao
 */
public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;

        /**
         * newInstance() 调用此方法，创建对应的运行时类对象
         * 实际上调用的是Person的空参构造器
         */

        Person instance = clazz.newInstance();

    }

    /**
     * 体会反射的动态性
     */
    @Test
    public void test2(){

        int num = new Random().nextInt(3);//0,1,2
        String classPath ="";
        switch (num){
            case 0:
                classPath= "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "com.dandan.reflection.Person";
                break;
        }

        try {
            System.out.println(getInstance(classPath));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }

    /**
     * 创建一个指定类的对象
     * @param classPath
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName(classPath);
        Class<?> aClass1 = aClass.newInstance().getClass();
        return aClass1;
    }
}
