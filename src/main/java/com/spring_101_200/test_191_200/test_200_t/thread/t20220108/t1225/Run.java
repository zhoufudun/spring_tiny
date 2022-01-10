package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1225;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class Run {

    public static void main(String[] args) {
        ThreadB b = new ThreadB();

        ThreadA a = new ThreadA(b);
        a.start();

        Utils.sleep(1000);
        ThreadC c = new ThreadC(b);
        c.start();

    }
}
