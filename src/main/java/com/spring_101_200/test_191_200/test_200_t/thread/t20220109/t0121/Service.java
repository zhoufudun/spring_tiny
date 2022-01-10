package com.spring_101_200.test_191_200.test_200_t.thread.t20220109.t0121;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Service {


    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("获得读锁" + Thread.currentThread().getName());
            Utils.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    // 类ReentrantLock 具有宿命互斥排他的效果，即同一时间只有一个线程在执行ReentranLock.lock()方法 后面的任务，这样做虽然保证了实例变量的线程
    // 安全性，但效率却是非常低下的，所以 在JDK 中提供了一种写锁ReentrantReadWriteLock类，使用它可以加快运行效率，在某些不需要
    // 操作实例变量的方法 中，完全可以使用读写涣ReentrantReadWriteLock来提升该方法的代码运行效率
    // 读写锁表示也可以有两个锁，一个是读取操作相关的锁，也称为共享锁，另外一个是写操作相关的锁，也叫排它锁，也就是多个锁之间不互斥
    // 读锁与写锁互斥，写锁与写锁互斥，在没有线程Thread 进入写操作时，进行读取操作的多个Thread都可以获取读锁，而进入写操作的Thread
    // 只有在获取写锁后才能进行写入操作，即多个Thread可以同时进行读取操作，但是同一时间，只允许一个Thread进入写操作
    // 从控制台中打印的时间来看，两个线程几乎同时进入了lock()方法后面的代码，说明在此使用了lock.readLock()读锁可以提高程序的运行效率，允许
    // 多个线程同时执行lock()方法后面的代码 。

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
                service.read();
            }
        });

        t1.setName("B");
        t1.start();

    }

}
