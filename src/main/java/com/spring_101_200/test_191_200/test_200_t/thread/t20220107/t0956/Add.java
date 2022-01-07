package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t0956;

public class Add {

    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }


    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}
