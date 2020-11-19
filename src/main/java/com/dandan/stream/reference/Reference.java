package com.dandan.stream.reference;

import com.dandan.interfaceTest;
import com.fasterxml.jackson.databind.util.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @date：2020/11/16
 * @author：suchao
 */
public class Reference {
    public static void main(String[] args) {


        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create();
        System.out.println(person.getFirstName());
        List<Object> list = new ArrayList();

       // Function<String, Integer> converter = (from) -> Integer.valueOf(from);
        Function<String, Integer> converter=Integer::valueOf;
        Integer sss = converter.apply("15");
        System.out.println(sss);
    }

}
