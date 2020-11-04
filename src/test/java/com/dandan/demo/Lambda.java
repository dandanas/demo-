package com.dandan.demo;

import com.dandan.bean.Animal;
import com.dandan.bean.Cat;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Author: dandan
 * @Date: 2020/11/2 10:40
 */
public class Lambda {

    @Test
    public void test(){
        int[] numbs = Arrays.copyOf( new int[]{1,6,3,2,1,7,8,21,19,41}, 10);
        String[] strings = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        System.out.println(Arrays.toString(numbs));
        Arrays.sort(strings, (a, b) -> Integer.valueOf(a) - Integer.valueOf(b));
        System.out.println(Arrays.toString(strings));

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("dog", "wangcai", 12));
        animals.add(new Animal("cat", "miaomiao", 1));
        animals.add(new Animal("person", "dandan", 91));
        animals.add(new Animal("person", "ex", 21));

        Collections.sort(animals, (a1, a2) -> a1.getName().compareTo(a2.getName()));
        System.out.println(animals);

        animals.stream().forEach(animal -> {
            animal.setNumber(animal.getAge() + 2);
            System.out.println(animal);
        });

        //Consumer<T>
        Consumer<Animal> anConsumer = animal -> System.out.println("Consumer : " + animal.toString());
        anConsumer.accept(animals.get(0));

        //Function<T, R>
        Function<Animal, Cat> catFunction = animal -> {
            return new Cat(animal.getType(), animal.getName(), animal.getAge(), animal.getNumber());
        };
        System.out.println("Function : " + catFunction.apply(animals.get(0)).toString());

        //静态方法引用
        Consumer<String> consumerStatic = Cat::staticName;
        consumerStatic.accept("dandan");

        Supplier<Cat> catSupplier = () -> new Cat("cat", "miao", 12, 21);
        System.out.println(catSupplier.get());

        //构造方法引用
        Supplier<Cat> catNewSupplier = Cat::new;
        System.out.println(catNewSupplier.get());

        Cat cat = new Cat("cat", "miao", 12, 12);
        //实例方法引用
        Consumer<String> consumer = cat::getCatName;
        consumer.accept("dandna");
    }
}
