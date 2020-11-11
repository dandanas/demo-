package com.dandan.Thread;

/**
 * 多线程创建方式一：继承子Thread类,重写run方法(将此线程要执行的方法声明在run方法中)，创建Thread类的子类对象，通过此对象调用start()
 * @date：2020/11/4
 * @author：suchao
 */

class MyThread extends Thread{


    @Override
    public void run() {
      for (int i = 0;i<1000;i++){
          if (i%2 == 0){
             // System.out.println(Thread.currentThread().getName());
          }
      }
    }
}

public class ThreadTest  {
    public static void main(String[] args) {

        //匿名类
        new Thread(){
            @Override
            public void run(){for (int i = 0;i<1000;i++){
                if (i%2 == 0){
                    System.out.println(Thread.currentThread().getName());
                }
            }

            }
        }.start();


        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0;i<100;i++){
            if (i%2 == 0){
               // System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
