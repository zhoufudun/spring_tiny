package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1846;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {


    private ReentrantLock lock = new ReentrantLock();

    private Condition newCondition = lock.newCondition();


    public void waitMethod() {
        try {
            lock.lock();
            newCondition.await();
            System.out.println("释放掉锁 " );
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("有没有线程正在等待 newCondition丝丝xx" );
        }
    }


    public void notifyMethod() {
        try {
            lock.lock();
            // hasWaiters(Condition condition) 的作用是查询是否有线程正在等待与此锁定相关的condition条件
            System.out.println("有没有线程正在等待 newCondition ? " + lock.hasWaiters(newCondition) + " 线程数是多少  ？ " + lock.getWaitQueueLength(newCondition));
            newCondition.signal();
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
