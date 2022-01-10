package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1232;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class ThreadB extends Thread {


    @Override
    synchronized public void run() {


        System.out.println("begin B threadName = " + Thread.currentThread().getName() + " " + System.currentTimeMillis());


        Utils.sleep(5000);
        System.out.println("end B threadName = " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }
}
