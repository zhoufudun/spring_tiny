package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1952;

import com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1606.MyThread;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            Calendar calendarRef = Calendar.getInstance();
            calendarRef.add(Calendar.SECOND, 10);
            lock.lock();
            System.out.println("wait begin timer = " + System.currentTimeMillis());
            condition.awaitUntil(calendarRef.getTime());
            System.out.println("wait end timeer =" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void  notifyMethod(){
        try {
            lock.lock();
            System.out.println("notify begin timer =" + System.currentTimeMillis());
            condition.signalAll();
            System.out.println("notify end timer = " + System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        Service service = new Service();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        }) .start();

    }
}
