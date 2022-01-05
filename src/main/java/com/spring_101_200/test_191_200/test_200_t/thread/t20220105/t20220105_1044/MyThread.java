package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1044;

public class MyThread extends Thread {


    private int i = 0;
    // java 线程中有两种线程，一种是用户线程，另外一种是守护线程
    // 守护线程是一种特殊的线程，它的特殊性有陪伴的含义，当进程中不存在非守护线程了，则守护线程自动销毁，典型的守护线程就是垃圾回收线程，
    // 当进程中没有非守护线程了，则垃圾回收线程也就没有存在的必要了，自动销毁，用个比较通俗的的比喻来解释一下，守护线程，任何一个守护线程都是整个
    // JVM中所有非守护线程的"保姆"，只要当JVM实例中存在任何一个非守护线程没有结束，守护线程就在工作，只有当最后一个非守护线程结束时，
    // 守护线程才随着JVM工作一同结束工作，Daemon的作用是为了其他线程的运行提供了便利的服务，守护线程最典型的应用就是GC(垃圾回收器)，它是
    //一个很称职的守护者。

    @Override
    public void run() {
        while (true) {
            try {
                i++;
                System.out.println("i = " + (i));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.setDaemon(true);
        myThread.start();
        Thread.sleep(5000l);
        System.out.println("我离开了thread对象也不再打印，也就是停止了！");
    }
}
