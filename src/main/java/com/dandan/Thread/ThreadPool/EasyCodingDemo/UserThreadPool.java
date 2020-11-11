package com.dandan.Thread.ThreadPool.EasyCodingDemo;

import java.util.concurrent.*;

/**
 * @date：2020/11/5
 * @author：suchao
 */
public class UserThreadPool {
    public static void main(String[] args) {
        /**
         * ThreadPoolExecutor中的参数
         * BlockingQueue<Runnable> workQueue;
         * 表示缓存队列，当请求的线程数大于corePoolSize时，线程进入BlockingQueue阻塞队列，
         * BlockingQueue队列缓存达到上限之后，如果还有新任务需要处理，那么线程池创建新的线程，最大线程数为maximumPoolSize
         */

        //缓存队列设置默认额长度为2，为了快速触发rejectHandler
        //LinkedBlockingDeque是单向链表，用锁在控制入队和出队的原子性，两个锁分别控制元素的添加和获取，是一生产消费模型的队列
        BlockingDeque queue = new LinkedBlockingDeque(2);

        //假设外部任务线程的来源由机房一和机房二混合调用
        UserThreadFactory f1 = new UserThreadFactory("第一机房");
        UserThreadFactory f2 = new UserThreadFactory("第二机房");



        UserRejectHandler userRejectHandler = new UserRejectHandler();

        //核心线程为1，最大线程为2，为了保证触发userRejectHandler
        ThreadPoolExecutor threadPoolExecutorFirst = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, userRejectHandler);
        //利用第二个线程工厂实例创建第二个线程池
        ThreadPoolExecutor threadPoolExecutorSecond = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f2, userRejectHandler);

        //创建400个任务线程
        Runnable task = new Task();
        for (int i = 0; i < 200; i++) {

            threadPoolExecutorFirst.execute(task);
            threadPoolExecutorSecond.execute(task);
        }

    }
}
