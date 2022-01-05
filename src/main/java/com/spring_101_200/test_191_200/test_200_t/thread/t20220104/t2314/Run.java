package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t2314;

public class Run {

    public static void main(String[] args)  throws Exception{
        DealThread t1 = new DealThread();
        t1.setFlag("a");
        Thread thread1 = new Thread(t1);
        thread1.start();


        Thread.sleep(100);



        t1.setFlag("b");
        Thread thread2= new Thread(t1);
        thread2.start();
    }
}
