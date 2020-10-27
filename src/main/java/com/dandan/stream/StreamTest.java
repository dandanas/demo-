package com.dandan.stream;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @date：2020/10/27
 * @author：suchao
 */
public class StreamTest {

    public static void main(String[] args) {

        Stream<Integer> integerStream = Stream.of(0, 1, 3);
//        integerStream.forEach(integer -> {
//            doPrint(integer);
//        });

        ArrayList<String> list = new ArrayList<>();
        list.add("haha");
        list.add("haha");
        list.add("heihei");
        list.add("huohuo");
        list.add("houhou");

        List<Integer> list4 = Arrays.asList(1, 2, 3,4);
        //reduce()接收两个参数，第一个是开始值，后面是一个函数表示累计
        Integer reduced = list4.stream().reduce(100, (a, b) -> a + b);
        System.out.println(reduced);

       // doPrint(list);

        List<String> collect = list.stream().distinct().collect(Collectors.toList());
      //  doPrint(collect);

        //列表任一元素含有h
        boolean isValid = list.stream().anyMatch(element -> element.contains("h"));
      //  System.out.println(isValid);
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("a");
        //列表元素全是a
        boolean isValidOne = list1.stream().allMatch(element -> element.contains("a"));
       // System.out.println(isValidOne);
        //列表任一元素不含
        boolean isValidTwo = list.stream().noneMatch(element -> element.contains("b"));
       // System.out.println(isValidTwo);

        //输出列表中包含h的String
        List<String> d = list.stream().filter(element -> element.contains("h")).collect(Collectors.toList());
        doPrint(d);

        List<String> list2 = list.stream().map(element -> convertElement(element)).collect(Collectors.toList());
      //  doPrint(list2);

        List<User> users = new ArrayList<>();

        users.add(new User("suchao",3,list4));
        users.add(new User("suchao2",3,list4));
        List<List<Integer>> collect1 = users.stream().map(user -> user.getTest()).collect(Collectors.toList());
        doPrint(collect1);

        //平铺返回
        List<Integer> a = users.stream().flatMap(user -> user.getTest().stream()).collect(Collectors.toList());
       // doPrint(a);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"a");
        map.put(2,null);
        //如果value为空或者key不存在，则把第二个参数作为value；
        String value = map.computeIfAbsent(2, s -> s.toString());
        String value1 = map.computeIfAbsent(3, s -> "aaa");
        String value2 = map.get(3);
        System.out.println(value);
        System.out.println(value1);
        System.out.println(value2);

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("alice", 100);
        salaries.put("jack", 200);
        salaries.put("mark", 300);

        salaries.replaceAll((name, oldValue) ->
                name.equals("alice") ? oldValue : oldValue + 200);

        System.out.println(salaries.get("jack"));


        salaries.forEach((name, salary) -> System.out.println(name + " 一个月 " + salary + " 块钱"));

        List<String> names = Arrays.asList("A", "B", "C", "D", "E");
        List<String> namesWithA = names.stream()
                .filter(name -> name.endsWith("A"))
                .collect(Collectors.toList());

        doPrint(namesWithA);
    }



    private static String convertElement(String element) {
        return element+"abc";
    }

    public static  <T> void doPrint(List<T> list) {
        list.stream().forEach(t->{
            System.out.println(t);
        });
    }
}
