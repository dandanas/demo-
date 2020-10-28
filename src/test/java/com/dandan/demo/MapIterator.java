package com.dandan.demo;

import org.junit.Test;

import java.util.*;

/**
 * @date：2020/10/28
 * @author：suchao
 * 遍历类
 */
public class MapIterator {

    @Test
    public void test() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String mapKey = entry.getKey();
            String mapValue = entry.getValue();
            System.out.println(mapKey + ":" + mapValue);
        }
    }

    /**
     * 只需要key 或者只需要set
     */
    @Test
    public void test02() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        //key
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        //value
        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    /**
     * 通过Iterator遍历
     */
    @Test
    public void test03() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + ":" + value);
        }
    }

    /**
     * 通过键找值遍历，这种方式的效率比较低，因为本身从键取值是耗时的操作
     */
    @Test
    public void test04() {
        Map<String, String> map = new HashMap<>();
        map.put("熊大", "棕色");
        map.put("熊二", "黄色");
        for(String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key+":"+value);
        } }

    @Test
    public void test05() {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.print("foEach模式：");
        set.forEach(integer -> {System.out.print(integer);});
        System.out.print("迭代模式：");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.print("for循环：");
        for(Integer i : set){
            System.out.println(i);
        }
    }

    @Test
    public void test06() {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        System.out.print("foEach模式：");
        set.forEach(integer -> {System.out.print(integer);});
        System.out.print("迭代模式：");
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next());
        }
        System.out.print("for循环：");
        for(Integer i : set){
            System.out.println(i);
        }
    }




}