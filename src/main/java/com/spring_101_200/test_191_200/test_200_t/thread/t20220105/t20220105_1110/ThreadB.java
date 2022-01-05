package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1110;

public class ThreadB extends Thread {

    public HasSelfPrivateNum numRef ;

    public ThreadB(HasSelfPrivateNum numRef ) {
        super();
        this.numRef = numRef;
    }

    @Override
    public void run() {
        super.run();
        numRef.addI("b");
    }
}
