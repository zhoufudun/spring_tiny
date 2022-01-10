package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1124;

public class ThreadB extends Thread {

    @Override
    public void run() {
        try {
            ThreadA a = new ThreadA();
            a.start();
            a.join();
            System.out.println("线程B 在run End处打印 了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
