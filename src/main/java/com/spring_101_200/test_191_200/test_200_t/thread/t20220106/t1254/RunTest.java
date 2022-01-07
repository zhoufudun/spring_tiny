package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1254;

public class RunTest {

    public static void main(String[] args) {
        MyList service = new MyList();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();


        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
