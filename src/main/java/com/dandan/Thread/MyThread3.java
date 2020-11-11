package com.dandan.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三  实现Callable接口
 * 1】创建Callable接口的实现类，并实现call()方法，然后创建该实现类的实例（从java8开始可以直接使用Lambda表达式创建Callable对象）。
 *
 * 2】使用FutureTask类来包装Callable对象，该FutureTask对象封装了Callable对象的call()方法的返回值
 *
 * 3】使用FutureTask对象作为Thread对象的target创建并启动线程（因为FutureTask实现了Runnable接口）
 *
 * 4】调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
 */
 class NewThread3 implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <=100 ; i++) {
            if (i%2==0){
                System.out.println(i);
                sum+=i;
            }
        }
        return sum;
    }
}

public class MyThread3{
    public static void main(String[] args) {
        NewThread3 myThread3 =new NewThread3();
        FutureTask futureTask = new FutureTask(myThread3);
        new Thread(futureTask).start();
        try {
            Object  o = futureTask.get();
            System.out.println("总和为："+o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
