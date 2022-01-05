package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1244;

public class Service {
    synchronized public void testMethod() {
        try {
            if (Thread.currentThread().getName().equals("a")) {
                System.out.println("ThreadName =" + Thread.currentThread().getName() + " run beginTime = " + System.currentTimeMillis());
                int i = 1;
                while (true) {
                    i++;
                    if (i > 100000) {
                        System.out.println("ThreadName =" + Thread.currentThread().getName() + " run exceptionTime = " + System.currentTimeMillis());
                        Integer.parseInt("a");
                    }
                }
            } else {
                System.out.println("Thread B run Time=" + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
