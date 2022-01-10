package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1143;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class ThreadA extends Thread {

    private ThreadB b ;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (b) {
            b.start();
            Utils.sleep(6000);
        }
    }


}
