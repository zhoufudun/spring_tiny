package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t1745;

public class MyThread extends Thread {

    private String num;

    public MyThread(ThreadGroup group, String name, String num) {
        super(group, name);
        this.num = num;
    }


    @Override
    public void run() {
        int numInt = Integer.parseInt(num);
        while (!this.isInterrupted() ) {
            System.out.println("死循环中 " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyThreadGroup group = new MyThreadGroup("我的线程组");
        MyThread[] myThreads = new MyThread[10];
        for(int i = 0 ;i < myThreads.length ;i ++){
            myThreads[i] = new MyThread(group,"线程" + (i + 1 ) ,"1");
            myThreads[i].start();
        }
        MyThread newT = new MyThread(group,"报错线程","a");
        newT.start();
    }
}
