package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t0950;

public class OutClass {

    static class Inner {
        public void method1() {
            synchronized (this) {
                for (int i = 0; i <= 10; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " i = " + i);
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void method2() {
            for (int i = 11; i <= 20; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + " i = " + i);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        final Inner inner = new Inner();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method1();
            }
        }, "A");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        }, "B");

        t1.start();
        t2.start();
    }
}
