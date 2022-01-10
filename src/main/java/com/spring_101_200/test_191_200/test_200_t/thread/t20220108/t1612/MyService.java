package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1612;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Utils.sleep(5000);
            System.out.println("methodA end threadName = " + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void methodB(){
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName=" + Thread.currentThread().getName() + " time = " + System.currentTimeMillis());
            Utils.sleep(5000);
            System.out.println("methodB begin ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyService myService = new MyService();
        for(int i = 0 ;i < 2 ;i ++){
          Thread t =   new Thread(new Runnable() {
                @Override
                public void run() {
                    myService.methodA();
                }
            });
            t.setName("A" + i );
            t.start();
        }

        for(int i = 0;i < 2 ;i ++){
          Thread t =   new Thread(new Runnable() {
                @Override
                public void run() {
                    myService.methodB();
                }
            });
            t.setName("B" + i );
            t.start();
        }




    }
}
