package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1729;

import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock = new ReentrantLock();

    public void serviceMethod1() {
        try {
            lock.lock();
            // 方法int getHoldCount() 的作用是查询当前线程保持此锁定的个数，也就是调用lock()方法的次数
            System.out.println("serviceMethod1 getHoldCount=" + lock.getHoldCount());
            serviceMethod2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void serviceMethod2() {
        try {
            lock.lock();
            System.out.println("serviceMethod2 getHostCount = " + lock.getHoldCount());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        service.serviceMethod1();
    }
}
