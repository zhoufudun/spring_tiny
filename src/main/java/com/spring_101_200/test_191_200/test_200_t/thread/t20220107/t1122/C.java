package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1122;

public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get 的值是 " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
