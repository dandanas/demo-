package com.dandan.Thread;

/**
 * @date：2020/11/22
 * @author：suchao
 */
public class STest {

    public static void main(String[] args) throws InterruptedException {
        STest sTest = new STest();
        new Thread(() -> {
            try {
                sTest.lock("test2==================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                sTest.lock("test3==================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public  void  lock(String flag) throws InterruptedException {

        synchronized (this){
        for (int i = 0; i < 1000; i++) {
            System.out.println(flag+i);
            Thread.sleep(100);
        }
        }
    }
}
