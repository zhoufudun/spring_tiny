package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1244;

public class Test {

    // 线程a出现异常并释放锁，线程b进入方法正常打印，实验的结论就是出现异常，锁被自动释放了
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();

        Thread.sleep(500);

        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }
}
