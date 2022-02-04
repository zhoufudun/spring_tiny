package com.t2022.t01.t13.t1035;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {
    public static Lock lock = new ReentrantLock();

    public static  Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("hello world ");
                    Utils.sleep(2000);
                    int i = 1 / 0 ;
                } catch (Exception e) {
                    e.printStackTrace();
                    Thread.currentThread().destroy();
                } finally {
                    System.out.println("finaly 块执行");
                }
            }
        });
        t.start();


    }


}
