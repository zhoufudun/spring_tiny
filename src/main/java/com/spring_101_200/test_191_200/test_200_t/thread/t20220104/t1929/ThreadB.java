package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1929;

public class ThreadB extends Thread {


    private Service service;
    private MyObject object;

    public ThreadB(Service service, MyObject object) {
        this.service = service;
        this.object = object;
    }


    @Override
    public void run() {
        super.run();
        service.testMethod1(object);
    }
}
