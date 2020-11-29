package com.dandan.collection;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date：2020/11/19
 * @author：suchao
 */
public class Generic {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
      List<Integer> integerList = new ArrayList<>();
      List<String> stringList = new ArrayList<>();
        System.out.println(integerList.getClass().equals(stringList.getClass())); //true

        System.out.println(integerList.getClass());
        integerList.getClass().getMethod("add", Object.class).invoke(integerList,"字符串");
        System.out.println(integerList.get(0)); //字符串


    }






}
