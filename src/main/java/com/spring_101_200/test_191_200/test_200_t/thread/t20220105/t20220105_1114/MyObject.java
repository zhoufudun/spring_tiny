package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1114;

public class MyObject  {


    // 此实验的结论是
    // 1)A线程先持有object对象的Lock锁，B 线程可以以异步的方式调用object对象中的非synchronized类型的方法
    // 2)A线程先持有object对象的Lock锁，B线程如果在这时调用 object对象中的synchronized类型的方法则需要等待，也就是同步
    public synchronized void methodA(){
        try {
            System.out.println("begin Method A threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000l);
            System.out.println("A end ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void methodB(){
        try {
            System.out.println("begin Method B threadName = " + Thread.currentThread().getName());
            Thread.sleep(5000l);
            System.out.println("B end ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
