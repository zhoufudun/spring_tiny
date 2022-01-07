package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t2359;

public class Test {


    public static void main(String[] args) throws Exception {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();


        ThreadB b = new ThreadB(lock);
        b.start();

        ThreadC c = new ThreadC(lock);
        c.start();

        Thread.sleep(1000);
        NotifyThread thread = new NotifyThread(lock);
        thread.start();
    }
}
