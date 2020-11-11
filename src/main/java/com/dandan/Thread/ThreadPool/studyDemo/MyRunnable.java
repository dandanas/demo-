package com.dandan.Thread.ThreadPool.studyDemo;

import java.util.Date;

/**首先创建一个 Runnable 接口的实现类
 * 这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
 * @date：2020/11/11
 * @author：suchao
 */
public class MyRunnable implements Runnable{
    private String command;

    public MyRunnable(String s ){
        this.command = s;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"start time:"+new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+"end time:"+new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
