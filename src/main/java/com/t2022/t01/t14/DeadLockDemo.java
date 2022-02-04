package com.t2022.t01.t14;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class DeadLockDemo {

    private static Object resource1 = new Object();

    private static Object resource2 = new Object();


    // 线程A 通过synchronized(resource1 ) 获取resource1 的监视器锁，然后通过 Thread.sleep(1000)，让线程休眠1s ，为了
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " get resource 1 ");
                    Utils.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " waiting get resource2 ");
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + " get resource 2 ");
                    }
                }
            }
        }, "A").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " get resource 1 ");
                    Utils.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " waiting get resource2 ");
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread().getName() + " get resource 2 ");
                    }
                }
            }
        }, "A").start();
    }
}
