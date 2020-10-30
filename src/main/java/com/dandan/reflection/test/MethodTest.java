package com.dandan.reflection.test;

import com.dandan.reflection.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 获取当前运行时类的方法
 * @date：2020/10/29
 * @author：suchao
 */
public class MethodTest {

    @Test
    public void test01(){

        Class<Person> aClass = Person.class;
        Method[] methods = aClass.getMethods();
        System.out.println("通过getMethods()方法拿到的：");
        //获取当前运行时类和其父类所有public访问权限的方法
        for (Method method : methods){
            System.out.println(method);
        }

        Method[] declaredMethods = aClass.getDeclaredMethods();
        //自己定义的方法(不包含父类中的方法）
        System.out.println("getDeclaredMethods()方法拿到的：");
        for (Method method : declaredMethods){
            System.out.println(method);
        }

    }
    /**
     * @注解
     * 权限修饰符，返回值类型，方法名（参数类型1 形参1，···） throws **Exception{}
     */
    @Test
    public void test(){
        //获取方法声明的注解
        Class<Person> aClass = Person.class;
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for(Method method : declaredMethods){
            //获取注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation:annotations){
                System.out.println(annotation );
            }
            //权限修饰符
            String s = Modifier.toString(method.getModifiers());
            System.out.println(s);
            //方法的返回值类型 TODO 需要时调API即可

        }
    }
}
