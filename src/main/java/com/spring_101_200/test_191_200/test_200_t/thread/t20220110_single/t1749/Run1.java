package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1749;

public class Run1 {

    // 前面介绍了若干个线程的异常处理方式，那么这些处理的方式如果放在一起的话，会出现什么样的运行结果呢？
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.setUncaughtExceptionHandler(new ObjectUncaughtExceptionHandler());
        MyThread.setDefaultUncaughtExceptionHandler(new StateUncaughtExceptionHandler());
        myThread.start();
    }
}
