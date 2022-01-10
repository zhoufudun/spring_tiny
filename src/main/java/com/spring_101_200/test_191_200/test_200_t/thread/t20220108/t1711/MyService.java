package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1711;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                condition.await();
            }
            System.out.println("打印*");
            hasValue = true;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void get(){
        try {
            lock.lock();
            while(!hasValue){
                condition.await();
            }
            System.out.println("打印~");
            hasValue = false;
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        MyService service = new MyService();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ;i < 100;i ++){
                    service.set();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
               for(int i = 0 ;i < 100;i ++){
                   service.get();
               }
            }
        }).start();

    }

}
