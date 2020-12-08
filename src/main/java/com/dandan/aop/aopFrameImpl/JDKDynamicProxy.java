package com.dandan.aop.aopFrameImpl;

import com.dandan.service.UserService;
import com.dandan.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @date：2020/12/8
 * @author：suchao 使用 动态代理实现
 */
public class JDKDynamicProxy {

    /**
     * 一 如何根据被加载到内存中的被代理类，动态创建一个代理类及其对象
     *
     * 二 当通过代理类的对象调用方法时，如何动态的去调用被代理类的同名方法
     */

    //返回一个代理类的对象
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(object);

        //第一个参数：被代理类的类加载器，第二个参数：被代理类实现的接口（因为代理类和被代理类要实现同样的接口）
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), myInvocationHandler);
    }
}

/**
 * 当通过代理类的对象调用方法时，如何动态的去调用被代理类的同名方法
 */
class MyInvocationHandler implements InvocationHandler {

    private Object obj;//需要使用被代理类对象赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当调用代理对象的方法时，会执行如下invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        UserUtil userUtil = new UserUtil();
        try {
            userUtil.before();

            method.invoke(obj, args);

            userUtil.afterReturn();
        } catch (Exception e) {
            e.printStackTrace();
            userUtil.e();
        } finally {
            userUtil.last();
        }

        return null;
    }
}

class Test {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        //proxyInstance代理类的对象
        UserService proxyInstance = (UserService) JDKDynamicProxy.getProxyInstance(userService);

        proxyInstance.queryUserById(1L);
        proxyInstance.queryUserById(-1L);
    }
}