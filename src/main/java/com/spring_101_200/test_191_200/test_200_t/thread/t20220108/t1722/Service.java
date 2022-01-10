package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1722;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock;

    public Service(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMehtod() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName() + " 获得锁定 ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        final Service service = new Service(false);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("* 线程" + Thread.currentThread().getName() + " 运行了");
                service.serviceMehtod();
            }
        };

        Thread[] threadArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadArray[i] = new Thread(runnable);
        }

        for (int i = 0; i < 10; i++) {
            threadArray[i].start();
        }
    }
}
