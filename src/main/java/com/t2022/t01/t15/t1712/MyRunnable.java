package com.t2022.t01.t15.t1712;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.Date;

public class MyRunnable implements  Runnable {

    private String command;

    public MyRunnable(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start.Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End.Time = " + new Date());
    }

    private void processCommand(){
        Utils.sleep(5000);
    }
}
