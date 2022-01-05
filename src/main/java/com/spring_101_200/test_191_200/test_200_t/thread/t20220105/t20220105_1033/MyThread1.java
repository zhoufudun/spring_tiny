package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1033;

import java.util.Random;

public class MyThread1 extends Thread {

    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 500000; i++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("* * * * * * thread1 1 user time = " + (endTime - beginTime));


    }
}
