package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1434;

public class Task {

    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("no synchronized threadName = " + Thread.currentThread().getName() + " i = " + (i + 1));
        }
        System.out.println("------------");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threaName = " + Thread.currentThread().getName() + " i = " + (i + 1));
            }
        }

    }
}
