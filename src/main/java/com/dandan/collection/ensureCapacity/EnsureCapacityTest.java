package com.dandan.collection.ensureCapacity;

import java.util.ArrayList;


/**
 *  如有必要，增加此 ArrayList 实例的容量，以确保它至少可以容纳由minimum capacity参数指定的元素数。
 *  list.ensureCapacity(N);
 * @date：2020/11/17
 * @author：suchao
 */
public class EnsureCapacityTest {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        //System.out.println("使用ensureCapacity方法前："+(endTime - startTime)); //2451
        System.out.println("使用ensureCapacity方法后："+(endTime - startTime)); //2109

    }
}