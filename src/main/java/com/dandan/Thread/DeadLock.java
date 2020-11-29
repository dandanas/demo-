package com.dandan.Thread;

import java.beans.Transient;

/**
 * 演示死锁的过程
 *
 * @date：2020/11/4
 * @author：suchao
 */
public class DeadLock {
    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();

        new Thread(){
            @Override
            public void run() {
                synchronized (stringBuffer){
                    stringBuffer.append("a");
                    stringBuffer2.append(1);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (stringBuffer2){
                        stringBuffer.append("b");
                        stringBuffer2.append(2);

                        System.out.println(stringBuffer);
                        System.out.println(stringBuffer2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (stringBuffer2){
                    stringBuffer.append("c");
                    stringBuffer2.append(3);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (stringBuffer){
                        stringBuffer.append("d");
                        stringBuffer2.append(4);

                        System.out.println(stringBuffer);
                        System.out.println(stringBuffer2);
                    }
                }
            }
        }).start();

    }
}
