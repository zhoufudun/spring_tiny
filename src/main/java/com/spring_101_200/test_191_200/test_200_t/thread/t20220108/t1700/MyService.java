package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1700;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();

    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA 时间为" + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA 时间为 " + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void awiatB() {
        try {
            lock.lock();
            System.out.println("begin awitB 时间为" + System.currentTimeMillis() + " threadName=" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awiatB 时间为 " + System.currentTimeMillis() + " ThreadName=" + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signAll_A时间为 " + System.currentTimeMillis() + " threadName = " + Thread.currentThread().getName());
            conditionA.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signAll_A时间为 " + System.currentTimeMillis() + " threadName = " + Thread.currentThread().getName());
            conditionA.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


    public static void main(String[] args) {
        MyService myService = new MyService();
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.awaitA();
            }
        });


        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                myService.awiatB();
            }
        });


        a.setName("A");
        a.start();

        b.setName("B");
        b.start();


        Utils.sleep(3000);

        myService.signalAll_A();

    }

}
