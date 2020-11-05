package com.dandan.Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @date：2020/11/4
 * @author：suchao
 */

class NewThreadPool implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if (i%2==0){
                System.out.println( Thread.currentThread().getName() );
                System.out.println(i);
            }
        }
    }
}

class NewThreadPool1 implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <=100 ; i++) {
            if (i%2!=0){
                System.out.println( Thread.currentThread().getName() );
                System.out.println(i);
            }
        }
    }
}

public class MyThread4 {
    public static void main(String[] args) {
        //输入的参数为固定的线程数，既核心线程数，又是最大线程数，不存在空线程
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //创建持有足够线程的线程池支持给定的并行度，并通过使用多个队列减少竞争，此方法把CPU数量设置为默认并行度
        //ExecutorService executorService =Executors.newWorkStealingPool();
        //MaximumPoolSize可以为Integer.MAX_VALUE，有OOM风险，KeepAliveTime默认为60秒，工作线程处于空闲状态，回收工作线程，任务数增加，则再次创建新线程处理任务
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //MaximumPoolSize可以为Integer.MAX_VALUE，有OOM风险，支持定时以及周期性任务，与newCachedThreadPool的区别是不回收工作线程
        //ExecutorService executorService = Executors.newScheduledThreadPool(10);
        //创建一个但线程的线程池，相当于单线程串行执行所有任务，保证按任务的提交顺序依次执行
        //Executors.newSingleThreadExecutor();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
        //线程池大小
        threadPoolExecutor.setCorePoolSize(12);
        //最大线程数
        threadPoolExecutor.setMaximumPoolSize(12);
        //线程没有任务时保持多长时间终止
        threadPoolExecutor.setKeepAliveTime(100, SECONDS);
        //executorService.submit(Callable  c);//适合适用于Callable
        executorService.execute(new NewThreadPool());//适合适用于Runnable
        executorService.execute(new NewThreadPool1());//适合适用于Runnable

        executorService.shutdown();
    }
}
