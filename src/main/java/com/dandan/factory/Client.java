package com.dandan.factory;

/**
 * @date：2020/11/16
 * @author：suchao
 */
public class Client {

    public static void main(String[] args) {
        Animal animal = AnimalFactory.produceAnimal("cat");
        animal.eat();

    }

}
