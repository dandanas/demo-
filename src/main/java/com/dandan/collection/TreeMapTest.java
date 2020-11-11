package com.dandan.collection;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @date：2020/11/3
 * @author：suchao
 * TreeMap是依靠Comparable或者Comparator来实现key的去重，而HashMap是使用hashCode和equals去重
 *
 */
public class TreeMapTest {
    public static void main(String[] args){
        //如果TreeMap换成HashMap则size为1
        TreeMap map = new TreeMap();
        //HashMap map = new HashMap();
        map.put(new Key(),"one");
        map.put(new Key(),null);
        System.out.println(map);
        System.out.println(map.size());
    }
}



class Key implements Comparable<Key> {

    @Override
    //返回负的常数，表示此对象永远小于输入的other对象，此处决定TreeMap的size=2
    public int compareTo(Key other) {
        return -1;
    }

    @Override
    //hash是相等的
    public int hashCode() {
        return 1;
    }

    @Override
    //equals也是相等的
    public boolean equals(Object obj){
        return true;
    }
}
