package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1021;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class MyService {

    synchronized static public void serviceMethod() {
        System.out.println(Thread.currentThread().getName() + " 进入了业务方法 ！ ");
        Utils.sleep(100000);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                MyService.serviceMethod();
            }
        });
        t1.setName("a");
        t1.start();

        Utils.sleep(200);
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                MyService.serviceMethod();
            }
        });
        t2.setName("b");
        t2.start();
        Utils.sleep(200);
        System.out.println("main方法中t2状态 " + t2.getState());
    }


}
