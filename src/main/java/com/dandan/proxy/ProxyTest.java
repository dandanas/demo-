package com.dandan.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date：2020/10/28
 * @author：suchao
 * 动态代理测试类
 */

interface Human{
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("I can eat"+food);
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("通用方法1");
    }

    public void method2(){
        System.out.println("通用方法2");
    }
}

/**
 * 如何根据被加载到内存中的被代理类，动态创建一个代理类及其对象
 *
 * 当通过代理类的对象调用方法时，如何动态的去调用被代理类的同名方法
 */
class ProxyFactory {
    //返回一个代理类的对象
    public static Object getProxyInstance(Object obj ){//obj:被代理类的对象，
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        //第一个参数：被代理类的类加载器，第二个参数：被代理类实现的接口（因为代理类和被代理类要实现同样的接口）
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类对象赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //当通过代理类的对象调用方法A时，就会调用如下的invoke()方法
    //将被代理类要执行的方法a的功能声明在invoke方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil humanUtil = new HumanUtil();
        humanUtil.method1();

        //即为代理类对象调用的方法，此方法也作为被代理类调用的方法
        //obj 被代理类的对象
        //invoke 该方法的返回值
        Object invoke = method.invoke(obj, args);

        humanUtil.method2();
        return invoke;
    }
}

public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        //proxyInstance代理类的对象
        Human  proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);

        proxyInstance.getBelief();
        proxyInstance.eat("peach");

    }


}
