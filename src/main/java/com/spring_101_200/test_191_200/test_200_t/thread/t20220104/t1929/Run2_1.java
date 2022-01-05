package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1929;

public class Run2_1 {

    public static void main(String[] args) {
        Service service = new Service();
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(service, object);
        a.setName("a");
        a.start();


        ThreadB b = new ThreadB(service, object);
        b.setName("b");
        b.start();
    }
}
