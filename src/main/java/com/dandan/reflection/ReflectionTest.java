package com.dandan.reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * @date：2020/10/29
 * @author：suchao
 */
public class ReflectionTest {

    //反射之前对于person类的操作

    @Test
    public void test1(){
         //创建Person对象
        Person person = new Person("dad",12);
        //通过对象调用方法
        person.id=10;
        System.out.println(person);
        person.getName();
        person.show();

        //在Person类外部是不可以通过person对象调用其私有结构以及私有构造器
    }

    //反射之后
    @Test
    public void test2() throws Exception {

        //通过反射创建Person类的对象
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, Integer.class);
        Person tom = (Person) constructor.newInstance("Tom", 12);
        System.out.println(tom);

        //通过反射掉用对象指定的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(tom,100);
        System.out.println(tom);

        Method show = clazz.getMethod("show");
        show.invoke(tom);

        /**
         *
         * 通过反射调用私有结构，包括构造器，方法，属性
         *
         * private String showNation(String nation){
         *         System.out.println("我的国籍是"+nation);
         *         return nation;
         *     }
         */
        Constructor declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person p2 = (Person) declaredConstructor.newInstance("shazi ");
        System.out.println(p2);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"erbaiwu");
        System.out.println(p2);

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String zhongguo = (String) showNation.invoke(p2, "zhonguo");

        System.out.println(zhongguo);

        System.out.println(p2 );


    }

    //获取Class实例的方式
    @Test
    public void test03() throws ClassNotFoundException {
        //调用运行时类的属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

        //通过运行时类的对象，最常用
        Person person = new Person();
        System.out.println(person.getClass());

        //调用Class的静态方法
        Class<?> aClass = Class.forName("com.dandan.reflection.Person");
        System.out.println(aClass);

        //用类加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<Person> aClass1 = (Class<Person>) classLoader.loadClass("com.dandan.reflection.Person");
        System.out.println(aClass);
    }

    //Class可以是哪些结构的说明
    @Test
    public void test04(){
        Class<Object> objectClass = Object.class;
        Class<Override> overrideClass = Override.class;
        Class<String[]> aClass = String[].class;
        Class<Integer> integerClass = int.class;
        Class<Void> voidClass = void.class;
        Class<Class> classClass = Class.class;
        Class<int[]> aClass1 = int[].class;
        Class<Comparable> comparableClass = Comparable.class;

        //只要数组的元素类型和维度一样，就是一个class 、
        int[] a = new int[10];
        int[] b = new int[20];
        Class<? extends int[]> aClass2 = a.getClass();
        Class<? extends int[]> aClass3 = b.getClass();

        assertEquals(aClass2,aClass3);
    }
}
