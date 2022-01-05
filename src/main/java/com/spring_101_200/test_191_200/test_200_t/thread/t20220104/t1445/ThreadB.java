package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1445;

public class ThreadB extends Thread {
    private ObjectService service;

    public ThreadB(ObjectService service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        super.run();
        service.serviceMethodB();
    }
}
