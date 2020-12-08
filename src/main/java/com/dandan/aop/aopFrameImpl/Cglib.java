package com.dandan.aop.aopFrameImpl;


import com.dandan.service.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @date：2020/12/9
 * @author：suchao 使用cglib 实现动态代理
 */
//使用 Enhancer 生成代理类
public class Cglib {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        // 设置目标对象为父类
        enhancer.setSuperclass(UserServiceImpl.class);
        // 设置回调方法
        enhancer.setCallback(new MethodCallBack());

        //创建代理对象
        UserServiceImpl userService = (UserServiceImpl) enhancer.create();

        userService.queryUserById(1L);
        userService.queryUserById(-1L);
    }
}


//定义方法拦截器
class MethodCallBack implements MethodInterceptor {
    UserUtil userUtil = new UserUtil();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        userUtil.before();
        try {
            methodProxy.invokeSuper(o, objects);
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