package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1727;

public class Main2 {


    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.setName("线程1");
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("线程：" + t.getName() + " 出现了异常");
                e.printStackTrace();
            }
        });

        t1.start();

        MyThread t2 = new MyThread();
        t2.setName("线程t2 ");
        t2.start();

    }
}
