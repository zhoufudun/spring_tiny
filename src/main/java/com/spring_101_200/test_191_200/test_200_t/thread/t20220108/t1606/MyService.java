package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1606;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private Lock lock = new ReentrantLock();


    public void testMethod() {
        lock.lock();

        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName = " + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        lock.unlock();
    }

    // 从运行的结果来看；，当前线程打印完毕之后，将锁进行释放，其他的线程才可以继续打印，线程打印的数据是分组打印，因为当线程已经持有锁
    // ，但是线程打印的顺序是随机的
    public static void main(String[] args) {
        MyService myService = new MyService();
        MyThread a1 = new MyThread(myService);
        MyThread a2 = new MyThread(myService);
        MyThread a3 = new MyThread(myService);
        MyThread a4 = new MyThread(myService);
        MyThread a5 = new MyThread(myService);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();

    }
}
