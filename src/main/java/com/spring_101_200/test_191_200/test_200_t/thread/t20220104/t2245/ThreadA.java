package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t2245;

public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.printA();
    }
}
