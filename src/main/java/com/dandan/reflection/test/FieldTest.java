package com.dandan.reflection.test;

import com.dandan.reflection.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的属性结构
 *
 * @date：2020/10/29
 * @author：suchao
 */
public class FieldTest {

     @Test
    public void test1(){
         Class<Person> clazz = Person.class;

         //获取属性结构
         //getFields(): 获取当前运行时类和其父类所有public访问权限的属性
         //Field[] fields = clazz.getFields();

         //getDeclaredFields():自己定义的属性(不包含父类中的属性）
         Field[] fields = clazz.getDeclaredFields();

         for (Field field : fields){
             System.out.println(field);
         }

     }

    @Test
    public void test2(){
        Class<Person> clazz = Person.class;

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields){
            //权限访问符
            int modifiers = field.getModifiers();
            System.out.println(Modifier.toString(modifiers ) );

            //数据类型
            Class<?> type = field.getType();
            System.out.println(type);

            //变量名
            String name = field.getName();
            System.out.println(name);
        }

    }
}
