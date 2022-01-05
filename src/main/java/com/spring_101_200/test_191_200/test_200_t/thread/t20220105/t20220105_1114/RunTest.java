package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1114;

public class RunTest {

    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");

        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}
