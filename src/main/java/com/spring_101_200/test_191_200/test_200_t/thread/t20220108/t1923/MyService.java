package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1923;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {


    public ReentrantLock lock = new ReentrantLock();


    public void waitMethod() {
        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + " 获得锁 ");
        } else {
            System.out.println(Thread.currentThread().getName() + " 没有获得锁 ");
        }
    }

    public static void main(String[] args) {
        final MyService service = new MyService();
        Runnable runnableRef = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };


        Thread threadA = new Thread(runnableRef);
        threadA.setName("A");
        threadA.start();


        Thread threadB = new Thread(runnableRef);
        threadB.setName("B");
        threadB.start();
    }
}
