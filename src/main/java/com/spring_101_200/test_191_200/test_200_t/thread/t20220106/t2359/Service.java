package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t2359;

public class Service {

    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin wait() threadName = " + Thread.currentThread().getName());
                lock.wait();
                System.out.println("end wait() ThreadNam= "  + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}
