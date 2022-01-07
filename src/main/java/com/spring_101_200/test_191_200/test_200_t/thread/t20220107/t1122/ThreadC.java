package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1122;

public class ThreadC extends Thread {


    private C c;

    public ThreadC(C p) {
        this.c = p;
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0 ;i < 10;i ++){
            c.getValue();
        }
    }
}
