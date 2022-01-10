package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1727;

public class MyThread extends Thread {

    @Override
    public void run() {
        String username = null;
        System.out.println(username.hashCode());
    }


    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
