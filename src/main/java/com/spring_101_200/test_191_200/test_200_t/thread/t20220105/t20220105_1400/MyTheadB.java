package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1400;

public class MyTheadB extends Thread {
    private Sub sub;

    public MyTheadB(Sub sub) {
        super();
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
