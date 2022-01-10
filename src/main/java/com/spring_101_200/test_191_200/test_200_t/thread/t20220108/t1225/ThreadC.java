package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1225;

public class ThreadC extends Thread {

    private ThreadB threadB;

    public ThreadC(ThreadB threadB) {
        this.threadB = threadB;
    }


    @Override
    public void run() {
        threadB.bService();
    }
}
