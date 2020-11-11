package com.dandan.collection;

import java.util.*;

import static java.util.Collections.*;

/**
 * @date：2020/10/26
 * @author：suchao
 */
public class Collection {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(4);
        list.add(3);
        list.add(5);
//将集合按照默认的规则排序,按照数字从小到大的顺序排序

        sort(list);
        System.out.println("list = " + list);
        System.out.println("===================");
//将集合中的元素反转
        reverse(list);
        System.out.println("list = " + list);
//addAll方法可以往集合中添加元素，也可往集合中添加一个集合
        addAll(list, 9, 20, 56);
//打乱集合中的元素
        shuffle(list);
        System.out.println("list = " + list);

//Arrays.asList方法可以返回一个长度内容固定的List集合
        List<String> list2 = Arrays.asList("tom", "kobe", "jordan", "tracy", "westbook", "yaoming", "ace", "stephen");
//按照字符串首字符的升序排列
        sort(list2);
        System.out.println("list2 = " + list2);
//这里是是使用匿名内部类来完成的
        sort(list2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //指定比较规则，按照首字母降序来排列
                return o2.charAt(0) - o1.charAt(0);
            }
        });
        System.out.println("list2 = " + list2);
//这里是使用lambda表达式来完成
        sort(list2, (o1, o2) -> {
            return o2.charAt(o2.length() - 1) - o1.charAt(o1.length() - 1);
        });
    }
}
