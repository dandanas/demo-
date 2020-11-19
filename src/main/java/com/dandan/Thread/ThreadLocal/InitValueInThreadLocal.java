package com.dandan.Thread.ThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * ThreadLocal无法解决共享对象更新的问题，所以使用某个引用来操作共享对象时，依然需要进行线程同步
 * @date：2020/11/18
 * @author：suchao
 */
public class InitValueInThreadLocal {

    private static final StringBuilder INIT_VALUE = new StringBuilder("init");

    private static final ThreadLocal<StringBuilder> builder = new ThreadLocal<StringBuilder>() {
        @Override
        protected StringBuilder initialValue() {
            return INIT_VALUE;
        }
    };

    private static class AppendStringThread extends Thread{
        @Override
        public void run() {
            StringBuilder inThread = builder.get();
            for (int i = 0; i < 10; i++) {
                inThread.append("-" + i);
            }
            System.out.println(inThread.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            new AppendStringThread().start();
        }
        TimeUnit.SECONDS.sleep(10);
    }
}
