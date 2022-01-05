package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t2018;

public class ThreadC extends Thread {


    private Service service;

    public ThreadC(Service service) {
        super();
        this.service = service;
    }


    @Override
    public void run() {
        service.printC();
    }
}
