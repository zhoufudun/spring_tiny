package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0122;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service {
    // ReentrantReadWriteLock的使用，写读互斥
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("获取锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("睡眠过后 释放读取锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }


    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("获取写锁" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
            Utils.sleep(4000);
            System.out.println("释放写锁 " + Thread.currentThread().getName() + " " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }


    public static void main(String[] args) {
        Service service = new Service();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                service.read();
            }
        });
        t.setName("A");
        t.start();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                service.write();
            }
        });
        t1.setName("B");
        t1.start();

    }

}
