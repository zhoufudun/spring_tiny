package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_0954;

public class MyThread extends Thread{



    private long i = 0 ;

    @Override
    public void run() {
        while(true){
            i ++ ;
        //    System.out.println(" i = " + i );
        }
    }

    public static void main(String[] args)  throws Exception{
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.suspend();
        System.out.println("main end ");
    }
}
