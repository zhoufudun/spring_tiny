package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1534;

public class MyThreadA extends Thread {
    private MyList list;


    public MyThreadA(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add("ThreadA " + (i + 1));
        }
    }
}
