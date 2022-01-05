package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1534;

public class MyThreadB extends Thread {
    private MyList list;


    public MyThreadB(MyList list) {
        super();
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            list.add("ThreadB " + (i + 1));
        }
    }
}
