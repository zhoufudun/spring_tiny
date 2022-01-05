package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1036;

public class RunTest {
    public static void main(String[] args) throws Exception {

        MyThreadA threadA = new MyThreadA();
        threadA.setPriority(1);
        threadA.start();


        MyThreadA threadB = new MyThreadA();
        threadB.setPriority(10);
        threadB.start();


        Thread.sleep(5000);

        threadA.stop();
        threadB.stop();
        //a = 3051634792
        //b = 3070856583
        System.out.println("a = " + threadA.getCount());
        System.out.println("b = " + threadB.getCount());


    }
}
