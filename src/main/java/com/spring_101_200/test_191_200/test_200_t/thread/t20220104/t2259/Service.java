package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t2259;

public class Service {


    public static void print(String stringParam) {
        synchronized (stringParam) {
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
