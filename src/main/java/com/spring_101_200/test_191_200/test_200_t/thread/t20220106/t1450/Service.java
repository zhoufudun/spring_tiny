package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1450;

public class Service {
    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                System.out.println("begin wait()");
                lock.wait();
                System.out.println(" end wait() ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
