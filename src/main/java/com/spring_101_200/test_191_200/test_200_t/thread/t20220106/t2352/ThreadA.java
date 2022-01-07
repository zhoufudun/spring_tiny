package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t2352;

public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        Service service = new Service();
        service.testMehtod(lock);
    }
}
