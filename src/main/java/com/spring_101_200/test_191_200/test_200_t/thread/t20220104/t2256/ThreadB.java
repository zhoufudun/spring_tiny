package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t2256;

public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.printB();
    }
}
