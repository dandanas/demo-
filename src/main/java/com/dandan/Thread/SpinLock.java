package com.dandan.Thread;

import java.util.concurrent.atomic.AtomicReference;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 自旋锁的示例
 */

@Slf4j
public class SpinLock {
    //一个Thread类的原子引用
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //加锁的方法
    public void myLock() {
        Thread currentThread = Thread.currentThread();
        log.info("myLock--Thread:{}", currentThread.getName());
        //这个就是自旋锁的核心，利用CAS比较当前原子引用中是否为null，如果是null，就把当前线程A放到里面去，
        // 此时线程B再到这里，那么就会CAS失败，一直在while循环中
        while (!atomicReference.compareAndSet(null, currentThread)) {

        }
    }

    //解锁的方法
    public void myUnlock() {
        Thread currentThread = Thread.currentThread();
        //CAS比较原子引用中是不是线程A，是的话就更新为null，此时在上面while中一直在自旋的线程B就可以跳出来了
        atomicReference.compareAndSet(currentThread, null);
        log.info("myUnlock--Thread:{}", currentThread.getName());
    }

    public static void main(String[] args) {
        SpinLock testMain80 = new SpinLock();

        //线程A，首先加锁，然后等3秒中，然后释放锁
        new Thread(() -> {
            testMain80.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testMain80.myUnlock();
        }, "A").start();

        //主线程等1秒，保证A线程先执行
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //线程B，加锁再释放锁
        new Thread(() -> {
            testMain80.myLock();
            testMain80.myUnlock();
        }, "B").start();


    }
}
