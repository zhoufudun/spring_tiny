package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1122;

public class ThreadP extends Thread {


    private P p ;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        super.run();
        for(int i = 0 ;i < 10 ;i ++){
            p.setValue();
        }
    }
}
