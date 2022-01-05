package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1236;

public class MyThread extends Thread {

    // 此实验说明，当存在父子类继承关系时，子类是完全可以通过可重入锁，调用父类中的同步方法的

    @Override
    public void run() {
        Sub sub = new Sub();
        sub.operateISubMethod();
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
