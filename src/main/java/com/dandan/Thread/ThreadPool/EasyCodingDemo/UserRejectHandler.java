package com.dandan.Thread.ThreadPool.EasyCodingDemo;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 执行拒绝策略的对象
 * @date：2020/11/5
 * @author：suchao
 */
public class UserRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task reject "+executor.toString());

    }
}
