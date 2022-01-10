package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1420;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class LockTest {
    public static final  Byte lock =new Byte("0");


    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LockTest.lock){
                    try {
                        LockTest.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();

        Utils.sleep(1000);

        System.out.println("main方法中的t的状态 ：" + t.getState());
    }
}
