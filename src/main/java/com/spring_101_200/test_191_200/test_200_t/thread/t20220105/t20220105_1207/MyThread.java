package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1207;

public class MyThread extends Thread {

    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }


    // 可重入锁 的概念是，自己可以再次获取自己的内部锁，比如有一个线程获得了对象的锁，此时这个对象锁还没有释放，当其他再次想获取这个对象的锁的
    // 时候还是可以获取的，如果不可锁重入的话，就会造成死锁。
    public static void main(String[] args) {
        MyThread mn = new MyThread();
        mn.start();
    }
}
