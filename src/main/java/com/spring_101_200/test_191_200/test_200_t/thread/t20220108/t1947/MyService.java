package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1947;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {


    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            lock.lock();
            System.out.println("wait begin ");
            condition.await();
            System.out.println("wait end ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" 线程名" + Thread.currentThread().getName() + " 异常");
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        MyService myService = new MyService();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.waitMethod();
            }
        });
        t.start();

        Utils.sleep(3000);
        t.interrupt();


    }

}
