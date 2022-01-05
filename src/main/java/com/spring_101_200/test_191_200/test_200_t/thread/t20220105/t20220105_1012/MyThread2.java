package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1012;

public class MyThread2 extends Thread {


    @Override
    public void run() {
        System.out.println("MyThread2 run priority=" + this.getPriority());
    }
}
