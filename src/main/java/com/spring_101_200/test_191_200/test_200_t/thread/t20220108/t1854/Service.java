package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1854;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock = new ReentrantLock();

    private Condition newCondition = lock.newCondition();


    public Service(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("公平锁的情况：" + lock.isFair());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        final Service service = new Service(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        final Service service1 = new Service(false);
        runnable = new Runnable() {
            @Override
            public void run() {
                service1.serviceMethod();
            }
        };

        thread = new Thread(runnable);
        thread.start();
    }
}
