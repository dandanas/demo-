package com.dandan.Thread.ThreadLocal;

import com.dandan.bean.Animal;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**软引用 在即将OOM之前，垃圾回收器会把这些软引用指向的对象加入回收范围，以获得更多的内存空间，让程序能健康运行
 *
 * 软引用一般用在同义服务器内缓存中间结果，如果命中缓存，则提取缓存结果，否则重新计算或获取；but软引用不是用来缓存高频数据的，如果出故障会导致所有访问直接指向数据库，
 * 导致数据库的压力时大时小，甚至崩溃
 *
 * @date：2020/11/18
 * @author：suchao
 */
public class ReferenceDemo {
    public static void main(String[] args) {
        //ArrayList<SoftReference> softReferences = new ArrayList<>();
        ArrayList<House> softReferences = new ArrayList<>();
        int i = 0;
        while (true){
            //SoftReference<House> buy2 = new SoftReference<>(new House());
           // softReferences.add(buy2);
            softReferences.add(new House());
            System.out.println("i="+i++);
        }
    }
}

class House{
    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];

    class Door {}
}
