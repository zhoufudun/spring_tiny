package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1733;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

    public ReentrantLock lock = new ReentrantLock();


    public void serviceMehtod1() {
        try {
            lock.lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + " 进入方法 ！");
            Thread.sleep(500000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 方法int getQueueLength()的作用是返回正在等待获取此锁定的线程会计数，比如 有5个线程，1 个线程首先执行awiat()方法，那么在调用
    // getQueueLength()方法的返回值是4 ，说明有4个线程同时在等待lock的释放

    public static void main(String[] args) {
        final Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMehtod1();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }

        Utils.sleep(2000);
        System.out.println("有线程数：" + service.lock.getQueueLength() + " 在等待获取的锁 ！ ");

    }
}
