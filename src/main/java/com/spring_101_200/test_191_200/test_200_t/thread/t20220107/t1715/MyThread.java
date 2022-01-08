package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1715;

public class MyThread extends Thread {

    @Override
    public void run() {
        try {
            int secondValue = (int) (Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
            System.out.println(Thread.currentThread().getName() + " 执行完毕  ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // 方法join的作用是使所有的属性的线程对象x正常执行run()方法中的任务，而使当前线程z进行无限的阻塞，等待线程x销毁执行z后面的代码
    // 方法join具体有使线程排队等待的运行作用，有些类似同步的处理效果，join和synchronized的区别是：join在内部使用wait()方法进行等待
    // 而synchroinzed 关键字使用的是对象监视器原理作为同步
    public static void main(String[] args)  throws Exception{
        MyThread myThread = new MyThread();
        myThread.setName("A");
        myThread.start();


        MyThread myThread1 = new MyThread();
        myThread1.setName("B");
        myThread1.start();

        myThread.join();
        System.out.println("我想当ThreadTest执行完毕后再执行，我做到了");
    }
}
