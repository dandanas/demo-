package com.dandan.reflection;

import java.io.Serializable;

/**
 * @date：2020/10/29
 * @author：suchao
 */
public class Creature<T> implements Serializable {

    private char gender;

    public double weight;

    private void breath(){
        System.out.println("呼吸");
    }

    public void eat(){
        System.out.println("吃东西");
    }



}
