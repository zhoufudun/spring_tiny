package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1724;

public class ThreadA extends Thread {

    @Override
    public void run() {
        for(int i = 0 ;i < Integer.MAX_VALUE ;i ++){
            String newString = new String();
            Math.random();
        }
    }
}
