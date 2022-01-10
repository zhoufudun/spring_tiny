package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1740;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock = new ReentrantLock();
    private Condition newCondition = lock.newCondition();


    public void waitMethod() {
        try {
            lock.lock();
            System.out.println("获得锁，开始执行 " + Thread.currentThread().getName());
            newCondition.await();
            System.out.println("执行结束 " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void notifyMethod() {
        try {
            lock.lock();
            System.out.println("有" + lock.getWaitQueueLength(newCondition) + " 个线程正在等待newCondition ");
            newCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        final Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
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
        service.notifyMethod();
    }


}
