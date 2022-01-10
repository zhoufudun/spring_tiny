package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1816;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    public ReentrantLock lock = new ReentrantLock();

    public Condition newCondition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            Utils.sleep(1000000000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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


        Thread threadA = new Thread(runnable);
        threadA.start();

        Utils.sleep(500);

        Thread threadB = new Thread(runnable);
        threadB.start();

        Utils.sleep(500);
        // hasQueuedThread()的作用是查询指定的线程是否正在等待获取此锁定
        // hasQueuedThreads()的作用是查询是否有线程正在等待获取此锁定
        System.out.println(service.lock.hasQueuedThread(threadA));
        System.out.println(service.lock.hasQueuedThread(threadB));
        System.out.println(service.lock.hasQueuedThreads());
    }

}
