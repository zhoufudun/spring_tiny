package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1606;

public class MyThread extends Thread {

    private MyService service;

    public MyThread(MyService service) {
        this.service = service;
    }


    @Override
    public void run() {
        service.testMethod();
    }
}
