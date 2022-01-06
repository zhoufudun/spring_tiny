package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1025;

public class MyService {
    private String lock = "123";

    public void testMethod() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " begin " + System.currentTimeMillis());

            lock = "456";
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " end " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        MyService service = new MyService();

        ThreadA a = new ThreadA(service);
        a.setName("A");
        ThreadB b = new ThreadB(service);
        b.setName("B");
        a.start();
        b.start();
    }
}
