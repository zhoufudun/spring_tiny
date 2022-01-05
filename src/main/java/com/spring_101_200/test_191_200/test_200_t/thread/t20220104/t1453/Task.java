package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1453;

public class Task {

    public void otherMethod() {
        System.out.println("-------------------run ----------otherMethod ");
    }

    public void doLongTimeTask() {
        synchronized (this) {
            for (int i = 0; i < 10000; i++) {
                System.out.println("synchronized threadName = " + Thread.currentThread().getName() + " i = " + (i + 1));
            }
        }
    }


}
