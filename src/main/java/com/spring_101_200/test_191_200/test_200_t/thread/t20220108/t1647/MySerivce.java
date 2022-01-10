package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1647;


import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MySerivce {

    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA 时间为" + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());
            condition.await();
            System.out.println(" end waitA 时间为 " + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void awiatB() {
        try {
            lock.lock();
            System.out.println("begin awaitB 时间为 " + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            condition.await();
            System.out.println(" end awaitB 时间为 " + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public void signalAll() {
        try {
            lock.lock();
            System.out.println("signnall 时间为 " + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MySerivce service = new MySerivce();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                service.awaitA();
            }
        });
        t.setName("A");
        t.start();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.awiatB();
            }
        });
        t1.setName("B");
        t1.start();

        Utils.sleep(3000);
        service.signalAll();
    }
}
