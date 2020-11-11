package com.dandan.Thread;

/**
 * 通过实现Runnable接口创建并启动线程一般步骤如下：
 *
 * 1定义Runnable接口的实现类，一样要重写run()方法，这个run（）方法和Thread中的run()方法一样是线程的执行体
 *
 * 2创建Runnable实现类的实例，并用这个实例作为Thread的target来创建Thread对象，这个Thread对象才是真正的线程对象
 *
 * 3第三部依然是通过调用线程对象的start()方法来启动线程
 * @date：2020/11/4
 * @author：suchao
 */
class MyThread2 implements Runnable {



    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}

public class MethodTest{
    public static void main(String[] args) {

       MyThread2 myThread=new MyThread2();
       Thread thread=new Thread(myThread);
       Thread thread1=new Thread(myThread);
       thread.start();
       thread1.start();
    }
}

