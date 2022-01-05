package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1400;

public class Sub extends Main {


    @Override
    public void serviceMethod() {
        try {
            System.out.println("int sub 下一步sleep begin threadName=" + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int sub 下一步sleep end threadName =" + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
