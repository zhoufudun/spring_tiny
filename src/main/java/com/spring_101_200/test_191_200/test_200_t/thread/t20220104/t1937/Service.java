package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1937;

public class Service {

    public void testMethod1(MyObject object){
        synchronized (object){
            try {
                System.out.println("testMethod1_______getLock time="+System.currentTimeMillis() + " run ThreadName="+Thread.currentThread().getName());
                Thread.sleep(200);
                System.out.println("testMethod1   releaseLock time = " + System.currentTimeMillis() + " run ThreadName="+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



}
