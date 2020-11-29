package com.dandan.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @date：2020/11/19
 * @author：suchao
 */
public class FailFastTest {


    public static void main(String[] args) {
        CopyOnWriteArrayList<Integer> arrayList =new CopyOnWriteArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        //子列表
        List<Integer> integerList = arrayList.subList(0, 2);
        arrayList.add(4);
        arrayList.remove(2);
        //subList.add(4);
        for (Integer integer:arrayList){
            System.out.println(integer);
        }


    }
}
