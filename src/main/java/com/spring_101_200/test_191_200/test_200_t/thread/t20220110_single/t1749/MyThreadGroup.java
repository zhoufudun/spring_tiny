package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1749;

public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        super.uncaughtException(t, e);
        System.out.println("线程组异常处理");
        e.printStackTrace();
    }
}
