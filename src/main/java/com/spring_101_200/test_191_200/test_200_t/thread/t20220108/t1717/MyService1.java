package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1717;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService1 {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                System.out.println("有可能**连续");
                condition.await();
            }
            System.out.println("打印*");
            hasValue = true;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                System.out.println("有可能··连续");
                condition.await();
            }
            System.out.println("打印··");
            hasValue = false;
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        MyService1 service = new MyService1();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        service.set();
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        service.get();
                    }
                }
            }).start();
        }

    }

}
