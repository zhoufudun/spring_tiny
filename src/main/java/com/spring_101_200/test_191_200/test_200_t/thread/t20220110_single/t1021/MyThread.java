package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1021;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class MyThread extends Thread {


    public MyThread() {
        // 构造函数中打印出来的日志其实是显示main主线程的状态为RUNNABLE
        System.out.println("构造方法中的状态 " + Thread.currentThread().getState());
    }

    @Override
    public void run() {
        System.out.println("run 方法中的状态 " + Thread.currentThread().getState());
    }


    public static void main(String[] args) throws Exception {
        // NEW
        // RUNNABLE
        // TERMINATED
        // BLOCKED
        // WAITING
        // TIMED_WATING
        MyThread myThread = new MyThread();
        System.out.println("main 方法中的状态 ：" + myThread.getState());
        Utils.sleep(1000);
        myThread.start();
        Utils.sleep(1000);
        System.out.println("main 方法中的状态为2:" + myThread.getState());

    }


}
