package com.dandan.aop.aopFrameImpl;

/**
 * @date：2020/12/8
 * @author：suchao
 */
public class LogUtil {

    public static void before(){
        System.out.println("方法开始执行了哦");
    }

    public static void afterReturn(){
        System.out.println("方法执行完了哦");
    }

    public static void e(){
        System.out.println("方法抛出异常了哦");
    }

    public static void last(){
        System.out.println("方法最后执行的");
    }
}
