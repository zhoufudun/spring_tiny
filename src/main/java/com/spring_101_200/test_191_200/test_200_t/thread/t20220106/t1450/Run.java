package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1450;

public class Run {


    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        ThreadB b = new ThreadB(lock);
        b.start();
    }
}
