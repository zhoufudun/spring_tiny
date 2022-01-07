package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1149;

public class Run {


    public static void main(String[] args) throws Exception {


        MyService myService = new MyService();
        MyThread[] array = new MyThread[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = new MyThread(myService);
        }

        for (int i = 0; i < array.length; i++) {
            array[i].start();
        }


        Thread.sleep(1000);

        System.out.println(myService.aiRef.get());
    }
}
