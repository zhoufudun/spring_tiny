package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1423;

public class ObjectService {
    public void serviceMethod(){
        synchronized (this){
            try {
                System.out.println("begin time = " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end end = " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
