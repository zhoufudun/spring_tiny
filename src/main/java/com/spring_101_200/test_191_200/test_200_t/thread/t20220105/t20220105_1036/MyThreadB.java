package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1036;

public class MyThreadB extends Thread {

    private long i = 0;

    public long getCount() {
        return i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}
