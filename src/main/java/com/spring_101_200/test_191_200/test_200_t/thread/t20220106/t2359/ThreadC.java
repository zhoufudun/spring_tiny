package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t2359;

public class ThreadC extends  Thread {


    private Object lock;

    public ThreadC(Object lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }
}
