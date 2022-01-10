package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1902;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock;

    private Service(boolean isFair) {
        lock = new ReentrantLock();
    }


    public void serviceMethod() {
        try {
            System.out.println("lock.isHeldByCuurentThread :" + lock.isLocked() );
            lock.lock();
            // 查询此锁定是否由任意线程保持
            System.out.println("lock.isHeldByCuurentThread :" + lock.isLocked());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        final Service service = new Service(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.serviceMethod();
            }
        }).start();
    }
}
