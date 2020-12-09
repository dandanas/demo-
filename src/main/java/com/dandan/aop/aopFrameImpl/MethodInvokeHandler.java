package com.dandan.aop.aopFrameImpl;

import com.dandan.service.OtherUserService;
import com.dandan.service.UserService;
import com.dandan.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;


/**
 * 将通知方法抽象为一个接口类
 */
interface Advisor {

    void before();

    void afterReturn();

    void afterThrowing();

    void after();

}

/**
 * 通知方法接口实现类
 */
class AdvisorImpl implements Advisor{

    @Override
    public void before() {
        System.out.println("方法执行前");
    }

    @Override
    public void afterReturn() {
        System.out.println("方法执行完了哦");
    }

    @Override
    public void afterThrowing() {
        System.out.println("方法抛出异常了哦");
    }

    @Override
    public void after() {
        System.out.println("方法最后执行啦啦啦");
    }
}

/**
 * 将jdk动态代理的invoke方法抽离为一个单独的类
 */
public class MethodInvokeHandler implements InvocationHandler {

    private Object obj;//需要使用被代理类对象赋值

    private  Advisor advisor;

    public MethodInvokeHandler(Advisor advisor,Object obj) {
        this.advisor = advisor;
        this.obj = obj;
    }

    //当调用代理对象的方法时，会执行如下invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        try {
            advisor.before();
            method.invoke(obj, args);
            advisor.afterReturn();
        } catch (Exception e) {
            e.printStackTrace();
           advisor.afterThrowing();
        } finally {
            advisor.after();
        }

        return null;
    }
}

/**
 * 将cglib方法抽离为一个单独的类
 */
class MyMethodCallBack implements MethodInterceptor {

    private  Advisor advisor;

    MyMethodCallBack(Advisor advisor) {
        this.advisor = advisor;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        advisor.before();
        try {
            methodProxy.invokeSuper(o, objects);
            advisor.afterReturn();

        } catch (Exception e) {
            e.printStackTrace();
            advisor.afterThrowing();

        } finally {
            advisor.after();
        }
        return null;
    }
}

/**
 * 如果实现了接口则使用jdk动态代理，如果没有实现接口就使用cglib
 * ProxyFactory类
 */
 class  ProxyFactory{

    private final Advisor advisor;

    ProxyFactory(Advisor advisor) {
        this.advisor = advisor;
    }


    //返回一个代理类的对象
    public  Object getJDKProxyInstance(Object object) {
        MethodInvokeHandler myInvocationHandler = new MethodInvokeHandler(advisor,object);

        object.getClass().getClassLoader();
        Thread.currentThread().getContextClassLoader();

        //第一个参数：被代理类的类加载器，第二个参数：被代理类实现的接口（因为代理类和被代理类要实现同样的接口）
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                object.getClass().getInterfaces() ,myInvocationHandler);


    }

    public Object getCglibInstance(Object object){

        Enhancer enhancer = new Enhancer();
        // 设置目标对象为父类
        enhancer.setSuperclass(object.getClass());
        //设置回调方法
        enhancer.setCallback( new MyMethodCallBack(advisor));

        return enhancer.create();

    }

    public static Object getProxyObject(Object object,Advisor advisor){
        if (Objects.isNull(object)){
            throw new IllegalStateException("目标对象不能为空");
        }
        ProxyFactory p =new ProxyFactory(advisor);
        if (object.getClass().getInterfaces().length>0){
            System.out.println("调用的是JDK动态代理");
           return p.getJDKProxyInstance(object);
        }else {
            System.out.println("调用的是cglib动态代理");
            return p.getCglibInstance(object);
        }
    }

}

class OtherAdvisor implements Advisor{

    @Override
    public void before() {
        System.out.println("我是用户自定义的before方法");
    }

    @Override
    public void afterReturn() {
        System.out.println("我是用户自定义的afterReturn方法");
    }

    @Override
    public void afterThrowing() {
        System.out.println("我是用户自定义的afterThrowing方法");
    }

    @Override
    public void after() {
        System.out.println("我是用户自定义的after方法");
    }
}

class test{
    public static void main(String[] args) {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        //AdvisorImpl advisor = new AdvisorImpl();

        //获取代理类的对象
        OtherUserService proxyObject = (OtherUserService)ProxyFactory.getProxyObject(userServiceImpl, new OtherAdvisor());
        proxyObject.otherUser();


    }
}


