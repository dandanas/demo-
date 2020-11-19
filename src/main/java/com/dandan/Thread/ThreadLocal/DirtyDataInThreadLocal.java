package com.dandan.Thread.ThreadLocal;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadLocal 会产生脏数据/脏数据 所以需要及时调用remove方法清理
 * @date：2020/11/18
 * @author：suchao
 */
public class DirtyDataInThreadLocal {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    public static void main(String[] args) {
        //使用固定大小为1的线程池，说明上一个线程属性会被下一个线程属性复用
        ExecutorService pool = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 2; i++) {
            Mythread myThread = new Mythread();
           pool.execute(myThread);

        }
    }

    private static class Mythread extends Thread {
        private static boolean flag = true;

        @Override
        public void run() {
            if(flag){
                //第一个线程set后没有进行remove，而第二个线程因为某种原因没有进行set操作
                threadLocal.set(this.getName());
                flag = false;
            }
            System.out.println(this.getName()+"线程是"+threadLocal.get());

        }

    }
}
