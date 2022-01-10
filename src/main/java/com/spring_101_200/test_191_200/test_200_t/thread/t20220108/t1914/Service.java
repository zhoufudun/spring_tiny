package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1914;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Service {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void waitMethod() {
        try {
            // 如果当前线程未被中断，则获取此锁定，如果已经被中断则出现异常
            lock.lockInterruptibly();
            System.out.println("lock begin " + Thread.currentThread().getName());
            for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
                String newString = new String();
                Math.random();
            }
            System.out.println("lock end " + Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("lock  异常 " + Thread.currentThread().getName());
        } finally {
            // isHeldByCurrentThread 的作用是查询当前线程是否保持此锁定
            if(lock.isHeldByCurrentThread()){
                System.out.println("true");
            }
            lock.unlock();

        }
    }


    public static void main(String[] args) {
        final Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.waitMethod();
            }
        };

        Thread threadA = new Thread(runnable);
        threadA.setName("A");
        threadA.start();

        threadA.interrupt();

        Utils.sleep(500);

        Thread threadB = new Thread(runnable);
        threadB.setName("B");
        threadB.start();

    //   threadB.interrupt();//打标记



        System.out.println("main end ! ");

    }

}
