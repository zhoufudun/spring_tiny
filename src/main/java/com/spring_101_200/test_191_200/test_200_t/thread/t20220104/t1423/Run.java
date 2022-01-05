package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1423;

public class Run {

    public static void main(String[] args) {
        ObjectService service = new ObjectService();
        ThreadA a = new ThreadA(service);
        a.setName("a");

        a.start();


        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }
}
