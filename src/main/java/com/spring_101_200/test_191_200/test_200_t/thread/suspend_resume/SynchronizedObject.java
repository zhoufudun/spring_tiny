package com.spring_101_200.test_191_200.test_200_t.thread.suspend_resume;

public class SynchronizedObject {

    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a线程永远suspend 了！");
            Thread.currentThread().suspend();
        }
        System.out.println("end ");
    }

    public static void main(String[] args) throws Exception {
        final SynchronizedObject object = new SynchronizedObject();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                object.printString();
            }
        };
        thread1.setName("a");
        thread1.start();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("thread2 启动了，但是进不了printString()方法");
                System.out.println("因为printString()方法被a线程锁定并且永远的suspend暂停了！");
                object.printString();
            }
        };
        thread2.start();
    }

}
