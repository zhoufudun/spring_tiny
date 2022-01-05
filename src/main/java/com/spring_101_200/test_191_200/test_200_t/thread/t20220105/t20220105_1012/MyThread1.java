package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1012;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread 1 run priority = " + this.getPriority());
        MyThread2 thread2 = new MyThread2();
        thread2.start();


    }

    // 在操作系统中，线程可以划分优先级，优先级较高的线程得到的CPU资源较多 ，也就是CPU优先级较高的线程对象中的任务
    //
    // 在Java中，线程的优先级分别为1-10这10个等级，如果小于1 或大于 10 ，则抛出throw new IllegalArgumentException()
    public static void main(String[] args) {
        System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main Thread end priority = " + Thread.currentThread().getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }

}
