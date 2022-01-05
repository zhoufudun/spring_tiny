package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t2259;

public class Run {


    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();


        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}
