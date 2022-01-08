package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1724;

public class ThreadB extends Thread {
    @Override
    public void run() {
        ThreadA a= new ThreadA();
        a.start();

    }
}
