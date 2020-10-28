package com.dandan.proxy;

import lombok.AllArgsConstructor;

/**
 * @date：2020/10/28
 * @author：suchao
 * 静态代理
 * 特点：代理类和被代理类在编译期间确定下来
 */
interface ClothFactory{

    void produceCloth();

}

//代理类
@AllArgsConstructor
class ProxyClothCloth implements ClothFactory{

    private ClothFactory factory;//拿被代类对象进行实例化

    @Override
    public void produceCloth() {

        System.out.println("代理工厂做准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做收尾");

    }

}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("耐克工厂生产一批憨憨");
    }
}

public class StaticProxy {
     public static void main(String[] args){
          ClothFactory nikeClothFactory = new NikeClothFactory();
          //创建代理类对象
         ClothFactory proxyClothCloth = new ProxyClothCloth(nikeClothFactory);

         proxyClothCloth.produceCloth();

     }
}
