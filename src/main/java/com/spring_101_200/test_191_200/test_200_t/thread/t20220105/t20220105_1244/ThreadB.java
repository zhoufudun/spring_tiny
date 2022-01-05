package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1244;

public class ThreadB extends Thread {


    private Service service;

    public ThreadB(Service service) {
        super();
        this.service = service;
    }


    @Override
    public void run() {
        service.testMethod();
    }
}
