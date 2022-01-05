package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1114;

public class ThreadB extends Thread {


    private MyObject object;

    public ThreadB(MyObject object) {
        super();
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}
