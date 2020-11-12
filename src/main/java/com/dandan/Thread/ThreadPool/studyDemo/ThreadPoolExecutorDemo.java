package com.dandan.Thread.ThreadPool.studyDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 代码中模拟了 10 个任务，我们配置的核心线程数为 5 、等待队列容量为 100 ，所以每次只可能存在 5 个任务同时执行，剩下的 5 个任务会被放到等待队列中去。当前的5个任务中如果有任务被执行完了，线程池就会去拿新的任务执行。
 */
public class ThreadPoolExecutorDemo {

    //核心线程数为 5
    private static final int CORE_POOL_SIZE = 5;
    //最大线程数是 10
    private static final int MAX_POOL_SIZE = 10;
    //任务队列为 ArrayBlockingQueue，并且容量为 100;
    private static final int QUEUE_CAPACITY = 100;
    //等待时间为 1L。
    private static final Long KEEP_ALIVE_TIME = 1L;
    public static void main(String[] args) {

        //使用阿里巴巴推荐的创建线程池的方式
        //通过ThreadPoolExecutor构造函数自定义参数创建
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
            Runnable worker = new MyRunnable("" + i);
            //执行Runnable
            //这边去笔记里面看一下这段的源码分析
            executor.execute(worker);
        }
        //终止线程池
        executor.shutdown();
        //这行代码可以类比一下自旋锁
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
