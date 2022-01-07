package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t2359;

public class NotifyThread extends Thread {


    private Object lock;

    public NotifyThread(Object lock) {
        this.lock = lock;
    }


    // 多次调用notify()方法唤醒了全部的WAITING中的线程
    // 前面示例中通过金疮调用notify()方法来实现唤醒3个线程，但并不能保证系统中仅有3个线程，也就是若notify()方法的调用次数小于线程
    // 对象的数量，会出现有部分线程对旬无法被唤醒的情况，为了唤醒全部线程，可以使用notifyAll()
    @Override
    public void run() {
        synchronized (lock) {
            lock.notify();
            lock.notify();
        }
    }
}
