package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1144;

public class ThreadC extends Thread {


    private C c;

    public ThreadC(C p) {
        this.c = p;
    }

    @Override
    public void run() {
        super.run();
        c.getValue();
    }
}
