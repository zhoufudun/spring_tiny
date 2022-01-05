package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1400;

public class MyTheadA extends Thread {
    private Sub sub;

    public MyTheadA(Sub sub) {
        super();
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }
}
