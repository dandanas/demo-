package com.dandan.collection;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.*;

/**
 * @date：2020/10/26
 * @author：suchao
 */
public class Collection {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer element:list){
            element++;
            System.out.println(element);
        }

       System.out.println(list);

        List<Integer> collect = list.stream().map(list1 -> list1 + 1).collect(Collectors.toList());
        System.out.println(collect);

        //System.out.println(list);
    }
}
