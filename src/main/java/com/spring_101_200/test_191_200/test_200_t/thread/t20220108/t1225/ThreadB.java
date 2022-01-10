package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1225;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class ThreadB extends Thread {

    public static long time ;

    @Override
    public void run() {
        time = System.currentTimeMillis();
        System.out.println(" b run begin timer = " + 0 );
        Utils.sleep(8000);
        System.out.println("b run end timer = " + (System.currentTimeMillis() - time));
    }


    synchronized  public void bService(){
        System.out.println("打印了bService timer = " +(System.currentTimeMillis() - time));
    }



}
