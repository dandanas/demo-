package com.dandan.collection;

/**
 * @date：2020/11/20
 * @author：suchao
 */
public class GenericDefinitionDemo<T> {

    static  GenericDefinitionDemo<String> d = new GenericDefinitionDemo<>();
    static <String,T,V> String get(String string,Long alibaba){
        return string;
    }

    public static void main(String[] args) {
        Integer first = 1;
        Long second = 2L;
        System.out.println(d.getClass());

        Integer integer = get(first, second);


    }



}
