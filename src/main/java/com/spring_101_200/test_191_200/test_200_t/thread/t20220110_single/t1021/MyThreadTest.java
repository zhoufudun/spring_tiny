package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1021;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class MyThreadTest {

    // new
    // RUNNABLE
    // TERMINATED
    // BLOCKED
    // WAITTING
    // TIMED_WAITING
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("begin sleep ");
                Utils.sleep(10000);
                System.out.println("end sleep");
            }
        });
        t.start();
        Utils.sleep(1000);
        System.out.println("main 方法中的状态 为" + t.getState());
    }
}
