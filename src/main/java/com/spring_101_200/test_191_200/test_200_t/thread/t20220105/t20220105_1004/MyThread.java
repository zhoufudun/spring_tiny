package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1004;

public class MyThread extends Thread {


    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 500000; i++) {
            // yield()方法的作用是放弃当前的CPU资源，将它让给其他的任务去占用CPU的执行时间，但是时间不确定，有可能刚刚放弃，马上又获得CPU的时间片
         //   Thread.yield();
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时 ：" + (endTime - beginTime) + "毫秒");

    }


    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
