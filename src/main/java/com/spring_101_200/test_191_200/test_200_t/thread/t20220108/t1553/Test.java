package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1553;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class Test {


    public static ThreadLocalExt t1 = new ThreadLocalExt();

    public static void main(String[] args) {



        for (int i = 0; i < 10; i++) {
            System.out.println("Main 线程中取值 " + t1.get());
            Utils.sleep(100);
        }

        Utils.sleep(5000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("ThreadA 线程中的值= " + t1.get());
                    Utils.sleep(100);
                }
            }
        }).start();

    }
}
