package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1058;

public class ThreadA extends Thread {

    public HasSelfPrivateNum numRef ;

    public ThreadA( HasSelfPrivateNum numRef ) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("a");
    }
}
