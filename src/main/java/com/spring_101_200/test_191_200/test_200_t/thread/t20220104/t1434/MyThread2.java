package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1434;


public class MyThread2 extends Thread {
    private Task task;

    public MyThread2(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
