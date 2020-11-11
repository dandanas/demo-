package com.dandan.Thread.ThreadPool.EasyCodingDemo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程工厂，用来生产一组相同任务的线程
 * @date：2020/11/5
 * @author：suchao
 */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;

    private final AtomicInteger nexId = new AtomicInteger(1);

    //定义线程组名称
     UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix="UserThreadFactory's"+whatFeatureOfGroup+"-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix+nexId.getAndIncrement();
        Thread thread = new Thread(null,task,name,0);
        System.out.println(thread.getName());
        return thread;
    }
}

//任务执行体
class Task implements Runnable{
    private final AtomicLong count = new AtomicLong(0L);

    

    @Override
    public void run() {
        System.out.println("running_"+count.getAndIncrement());
    }
}





