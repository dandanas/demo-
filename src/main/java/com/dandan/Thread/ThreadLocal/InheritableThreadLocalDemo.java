package com.dandan.Thread.ThreadLocal;

/**
 * @date：2020/11/12
 * @author：suchao
 */
public class InheritableThreadLocalDemo {
        public static void main(String[] args) {
            ThreadLocal<String> ThreadLocal = new ThreadLocal<>();
            ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
            ThreadLocal.set("父类数据:threadLocal");
            inheritableThreadLocal.set("父类数据:inheritableThreadLocal");

            new Thread(() -> {
                System.out.println("子线程获取父类`ThreadLocal`数据：" + ThreadLocal.get());
                System.out.println("子线程获取父类inheritableThreadLocal数据：" + inheritableThreadLocal.get());
            }).start();
        }


}
