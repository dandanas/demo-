package com.dandan.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

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
public class lambdaTest {

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
        List<String> list = Arrays.asList("aaa1","bbb1","ccc");
        //filterString(list, s -> {s.contains("1")});
        List<String> filterString = filterString(list, s -> s.contains("1"));

        System.out.println(filterString);

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
        Function<Integer,String[]> function = length -> new String[length];

        String[] apply = function.apply(10);

        System.out.println(Arrays.toString(apply));

        //数组引用
        Function<Integer,String[]> function1 =String[] :: new;
        String[] apply1 = function.apply(5);

        System.out.println(Arrays.toString(apply1));

    }

}
