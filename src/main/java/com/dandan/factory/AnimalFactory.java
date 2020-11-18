package com.dandan.factory;

/**
 * @date：2020/11/16
 * @author：suchao
 */
public class AnimalFactory {

    public static Animal produceAnimal(String type){
        Animal animal = null;
        if(type.equals("cat")){
            return new Cat();
        }else {
            return new Dog();
        }
    }
}
