package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1640;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {


    private Lock lock = new ReentrantLock();


    public Condition condition = lock.newCondition();


    public void awiat() {
        try {
            lock.lock();
            System.out.println("Wait 时间为" + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal 时间 为" + System.currentTimeMillis());
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        MyService myService = new MyService();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myService.awiat();
            }
        }).start();


        Utils.sleep(3000);

        myService.signal();


    }
}
