package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t0956;


public class ThreadSub extends Thread {
    private Subtract p;


    public ThreadSub(Subtract p) {
        this.p = p;
    }


    @Override
    public void run() {
        p.substract();
    }
}

