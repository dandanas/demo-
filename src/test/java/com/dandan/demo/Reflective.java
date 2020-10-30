package com.dandan.demo;

import com.dandan.bean.Animal;
import com.dandan.bean.Cat;
import com.dandan.utils.ObjectAnalyzer;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: dandan
 * @Date: 2020/10/29 14:28
 */
public class Reflective {

    @Test
    public void test() {
        Class c1 = int.class;
        System.out.println("int.class : " + c1);
        Class doubleClass = double[].class;
        System.out.println("double[].class : " + doubleClass);
        Class c2 = null;
        try {
            c2 = Class.forName("com.dandan.bean.Animal");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("com.dandan.bean.Animal : " + c2.getName());
        Class c3 = Cat.class;
        System.out.println("Cat.class : " + c3);
        Class c4 = Animal[].class;
        System.out.println("Animal[].class : " + c4);
        Cat cat = new Cat();
        Class c5 = cat.getClass();
        System.out.println("cat.getClass() : " + c5);
        try {
            /**
             * Cat 以及其父类必须要有无参的构造函数
             */
            Cat cat1 = (Cat) (c3.newInstance());
            cat1.setName("dandan");
            System.out.println(cat1.getName());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reflective(){
        Class cat = Cat.class;
        Field[] fields = cat.getDeclaredFields();
        System.out.println("Fields : ");
        for (Field field: fields) {
//            System.out.println(Modifier.toString(field.getModifiers()));
//            System.out.println(field.getDeclaringClass());
//            System.out.println(field.getName() + " --> type : " + field.getType() + " --> " + field);
        }

        Method[] methods = cat.getDeclaredMethods();
        System.out.println("Methods : ");
        for (Method method : methods) {
            System.out.println(Arrays.toString(method.getParameterTypes()));
//            System.out.println(Modifier.toString(method.getModifiers()));
//            System.out.println(method.getDeclaringClass());
//            System.out.println(Arrays.toString(method.getExceptionTypes()));
//            System.out.println(method.getName() + " --> " + method);
        }
        Constructor[] constructors = cat.getDeclaredConstructors();
        System.out.println("Constructors : ");
        for (Constructor constructor: constructors) {
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
//            System.out.println(Modifier.toString(constructor.getModifiers()));
//            System.out.println(constructor.getDeclaringClass());
//            System.out.println(constructor.getName() + " --> " + constructor);
        }
    }

    /**
     * 在运行时使用反射分析对象
     */
    @Test
    public void test3(){
        Animal animal = new Animal("person", "dandan", 12);
        animal.setNumber(10);
        System.out.println("更改前 : " + animal);
        Class animalClass = animal.getClass();
        // type 与name 都是可见的 public
        Field type = null;
        Field number = null;
        // name 是 private
        Field name = null;
        try {
            type = animalClass.getDeclaredField("type");
            number = animalClass.getDeclaredField("number");
            name = animalClass.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Object animalBuild = null;
        Object animalAgeBuild = null;
        Object animalNameBuild = null;
        try {
            //获取 animal 对象中各个 Field 的值
            animalBuild = type.get(animal);
            animalAgeBuild = number.get(animal);

            //覆盖访问控制
            name.setAccessible(true);
            animalNameBuild = name.get(animal);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("animal type : " + animalBuild);
        System.out.println("animal age : " + animalAgeBuild);
        System.out.println("animal name : " + animalNameBuild);
        try {
            //更改 animal 对象中 type Field 的值
            type.set(animal, "dog");
            number.setInt(animal, 100);
            name.set(animal, "sahbi");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("更改后 : " + animal);
    }

    @Test
    public void test4(){
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cat", "dandan", 12));
        animals.add(new Animal("dog", "dn", 2));
        animals.add(new Animal("person", "anthony", 21));
        animals.add(new Animal("duck", "rock", 12));
        System.out.println(new ObjectAnalyzer().toString(animals));
    }

    @Test
    public void test5(){
        Animal[] animals = new Animal[10];
        Object[] objects = new Object[10];
//        System.arraycopy(animals, 0, objects, 0, Math.min(objects.length, animals.length));
        objects = (Animal[]) copyOf(animals, 50);
        animals = (Animal[]) objects;
        System.out.println(animals.getClass());
        System.out.println(objects.getClass());
    }

    @Test
    public void test6(){
        Animal animal = new Animal("dog", "rock", 12);
        animal.setNumber(2);
        System.out.println("animal begin changed : " + animal);
        Class animalClass = animal.getClass();
        Method test = null;
        Method toString = null;
        Method setType = null;
        try {
            //获取Animal 类对象的方法
            test = animalClass.getDeclaredMethod("Test");
            toString = animalClass.getDeclaredMethod("toString");
            setType = animalClass.getDeclaredMethod("setType", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println("通过反射调用 begin");
        try {
            // invoke 调用参数对象的该方法
            test.invoke(animal);
            System.out.println("通过invoke调用 : " + toString.invoke(animal));
            setType.invoke(animal, "cat");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("反射调用 end");
        System.out.println("animal end changed : " + animal);
    }

    private static Object copyOf(Object a, int newLength){
        //获取数组的类对象
        Class c = a.getClass();
        //确认类对象是数组
        if(!c.isArray()){
            return null;
        }
        //确认数组对应的类型
        Class componentType = c.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}
