package com.dandan.Thread;

/**
 * 线程通信
 * @date：2020/11/4
 * @author：suchao
 */

class Number implements Runnable{

    private int num = 1;

    @Override
    public void run() {

        while (true){
            if(num<=100){
                System.out.println(Thread.currentThread().getName()+":"+num);
                num++;
            }
        }
    }
}

public class CommunicationTest {

    public static void main(String[] args) {
        Number number = new Number();
        Thread thread1 = new Thread(number);
        Thread thread2 = new Thread(number);

        thread1.start();
        thread2.start();
    }
}
