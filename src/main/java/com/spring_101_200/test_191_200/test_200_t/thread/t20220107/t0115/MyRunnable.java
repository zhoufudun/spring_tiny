package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t0115;

public class MyRunnable {

    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("wait begin timer = " + System.currentTimeMillis());
                    lock.wait(5000);
                    System.out.println("wait end timer = " + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };


    static private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("notify begin timer = " + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end timer = " + System.currentTimeMillis());
            }
        }
    };

    // 打印日志中wait begin 的时间尾数为3879 ，在3000毫秒后，notify begin 6879 被执行，也就是在此时间点准备对呈WAITING状态的线程进行唤醒
    public static void main(String[] args)  throws Exception{
        Thread t1 = new Thread(runnable1);
        t1.start();

        Thread.sleep(3000);
        Thread t2 = new Thread(runnable2);
        t2.start();

    }
}
