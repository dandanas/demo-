package com.dandan.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @date：2020/11/16
 * @author：suchao
 */

@Data
@NoArgsConstructor
public class Cat implements Animal{

    private int age;

    private int life;

    @Override
    public void eat() {
        System.out.println("喵喵喵");
    }

    public Cat(int age) {
        this.age = age;
        this.life = 20;
    }
}
