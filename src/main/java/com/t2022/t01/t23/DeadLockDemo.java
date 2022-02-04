package com.t2022.t01.t23;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";


    // 避免一个线程同时获取多个锁
    // 避免一个线程在锁内購占用多个资源，尽量保证每个锁只占用一个资源 。
    // 深度使用定时锁，使用lock.tryLock(timeout)来替代使用内部锁机制 。
    // 对于数据库锁，加锁和解锁必须在一个数据库链接里，否则会出现失败的情况。
    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }


    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    Utils.sleep(2000);
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B) {
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
