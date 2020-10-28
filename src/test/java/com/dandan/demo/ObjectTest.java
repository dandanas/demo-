package com.dandan.demo;

import com.dandan.bean.Animal;
import com.dandan.bean.Cat;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: dandan
 * @Date: 2020/10/28 10:20
 */
public class ObjectTest {

    @Test
    public void test(){
        Animal an = new Animal("cat", "dandan", 12);
        Animal bn = new Animal("cat", "dandan", 12);
        Animal cn = an;
        //引用不同的对象
        System.out.println("an == bn : " + (an == bn));
        //引用同一个对象
        System.out.println("an == cn : " + (an == cn));
        System.out.println("an.equals(bn) : " + an.equals(bn));
        System.out.println("an.equals(cn) : " + an.equals(cn));

        Cat cat = new Cat("cat", "dandan", 12, 4);
        System.out.println(cat.equals(an));

        System.out.println("hascode()");
        System.out.println(an.hashCode());
        System.out.println(cn.hashCode());

        int[] arr = new int[]{1,2,3,4,5};
        System.out.println(arr.toString());
        System.out.println(Arrays.toString(arr));

        System.out.println(an.toString());
        System.out.println(cat.toString());
     }
}
