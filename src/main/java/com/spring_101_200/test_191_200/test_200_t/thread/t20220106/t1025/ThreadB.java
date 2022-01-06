package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1025;

public class ThreadB extends Thread {


    private MyService service;

    public ThreadB(MyService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.testMethod();
    }
}
