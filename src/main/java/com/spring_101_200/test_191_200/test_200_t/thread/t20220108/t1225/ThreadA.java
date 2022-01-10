package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1225;

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
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("释放了锁 ");
            for(int i = 0 ;i < Integer.MAX_VALUE ;i ++){
                String newString = new String();
                Math.random();
            }
        }
    }


}
