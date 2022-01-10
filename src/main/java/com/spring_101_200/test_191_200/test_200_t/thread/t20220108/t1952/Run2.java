package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1952;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class Run2 {


    public static void main(String[] args) {
        Service service = new Service();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        }).start();


        Utils.sleep(2000);

        // 线程在等待时间到达之前被提前唤醒
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.notifyMethod();
            }
        }).start();

    }
}
