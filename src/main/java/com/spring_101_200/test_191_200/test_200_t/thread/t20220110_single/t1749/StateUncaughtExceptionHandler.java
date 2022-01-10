package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1749;

public class StateUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("静态的异常处理");
        e.printStackTrace();
    }
}
