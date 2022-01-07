package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t0110;

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


    // 当然也可以在5秒之内由其他的线程进行唤醒
    public static void main(String[] args) {
        Thread t = new Thread(runnable1);
        t.start();
    }
}
