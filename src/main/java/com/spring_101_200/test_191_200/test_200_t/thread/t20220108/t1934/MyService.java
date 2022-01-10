package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1934;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {


    private ReentrantLock lock = new ReentrantLock();

    public void waitMethod() {
        try {
            if (lock.tryLock(3, TimeUnit.SECONDS)) {
                System.out.println("       " + Thread.currentThread().getName() + " 获得锁的时间 ：" + System.currentTimeMillis());
                Thread.sleep(10000);
            } else {
                System.out.println("      " + Thread.currentThread().getName() + " 没有获得锁 " + System.currentTimeMillis());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" 线程名" + Thread.currentThread().getName() + " 异常");
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        final MyService service = new MyService();
        Runnable runnableRef = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 调用waitMethod 时间 ：" + System.currentTimeMillis());
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnableRef);
        threadA.setName("A");
        threadA.start();


        Thread threadB = new Thread(runnableRef);
        threadB.setName("B");
        threadB.start();
    }

}
