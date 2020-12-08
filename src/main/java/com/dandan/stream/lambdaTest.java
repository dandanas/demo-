package com.dandan.stream;

import com.dandan.logAop.TimeConsuming;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @date：2020/10/28
 * @author：suchao
 * java 内置的四大函数式接口
 *
 * 消费型接口 Consumer<T> void accept (T t)
 * 供给型接口 Supplier<T> T get()
 * 函数型接口 Function<T,R> R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 */
public class lambdaTest{


    @Test
    public void test1(){
        happy(100, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("买买买"+aDouble);
            }
        });
    }

    public void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){
        happy(100,(aDouble)->System.out.println("买买买"+aDouble));
    }

    @Test
    public void test3(){
        List<String> list = Arrays.asList("aaa1","bbb1","ccc");
        List<String> filterString = filterString(list, s -> s.contains("1"));

        System.out.println(filterString);

    }

    //根据指定规则过滤集合中的字符串，此规则由Predicate中的方法决定
    public ArrayList<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> filterStrings = new ArrayList<>();
        for(String s :list) {
            if (predicate.test(s)) {
                filterStrings.add(s);
            }
        }

        return filterStrings;

    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("aaa1","aaa2","bbb1","ccc");

        // 测试 Sort (排序)
        list.stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);// aaa1 aaa2


    }

    //构造器引用
    @Test
    public void test5(){

        //lambda表达式实现
        Supplier<User> supplier = () -> new User();
        User user = supplier.get();

        //构造器引用
        Supplier<User> supplier1 = User::new;
    }

    //数组引用
    @Test
    public void test6(){

        //lambda表达式实现
        Function<Integer,String[]> function = (length) -> new String[length];

        String[] apply = function.apply(10);

        System.out.println(Arrays.toString(apply));

        //数组引用
        Function<Integer,String[]> function1 =String[] :: new;
        String[] apply1 = function1.apply(5);

        System.out.println(Arrays.toString(apply1));

    }

    @Test
    public void test(){
        List<String> stringList = Arrays.asList("peter", "anna", "mike", "xenia");

        // 测试 Map 操作
        stringList
                .stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


    }
    @Test
    //@TimeConsuming(fullMethodName = true)
    public void test9(){
        List<String> stringList = Arrays.asList("peter", "anna", "mike", "xenia");
        //测试 Reduce (规约)操作

        Optional<String> reduced = stringList
                .stream()
                .sorted()
                .reduce((s1, s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);

        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println(minValue);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(sumValue);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
        System.out.println(concat);

    }


}
