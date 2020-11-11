package com.dandan.Thread.ThreadLocal;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @date：2020/11/10
 * @author：suchao
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        final ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("hello");
        System.out.println("main thread:" + threadLocal.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("world");
                System.out.println("new Thread1:" + threadLocal.get());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("!!!");
                System.out.println("new Thread2:" + threadLocal.get());
            }
        }).start();

    }
}
