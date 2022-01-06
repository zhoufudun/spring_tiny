package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1047;

public class Run {

    public static void main(String[] args) throws Exception {
        Service service = new Service();
        UserInfo userInfo = new UserInfo();
        ThreadA a = new ThreadA(service, userInfo);
        a.setName("a");
        a.start();
        Thread.sleep(50);


        ThreadB b = new ThreadB(service, userInfo);
        b.setName("b");
        b.start();

    }
}
