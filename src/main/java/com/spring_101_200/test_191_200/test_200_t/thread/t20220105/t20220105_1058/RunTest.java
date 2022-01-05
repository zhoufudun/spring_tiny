package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1058;

public class RunTest {

    public static void main(String[] args) {
        HasSelfPrivateNum numRef = new HasSelfPrivateNum();
        ThreadA athread = new ThreadA(numRef);
        ThreadB bthread = new ThreadB(numRef);

        athread.start();
        bthread.start();
    }
}
