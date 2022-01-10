package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1749;

public class MyThread extends Thread {

    private String num = "a";

    public MyThread() {
    }

    public MyThread(ThreadGroup group, String name) {
        super(group,name);
    }

    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        System.out.println("在线程中打印 ：" +(numInt + 1 ));
    }
}
