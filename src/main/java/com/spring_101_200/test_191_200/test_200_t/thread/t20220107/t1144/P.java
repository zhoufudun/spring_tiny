package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1144;


public class P {

    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println(" " + Thread.currentThread().getName() + " Waiting 了 * ");
                    lock.wait();
                }

                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println(" " + Thread.currentThread().getName() + " Running 了 ,set的值是 " + value);
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

