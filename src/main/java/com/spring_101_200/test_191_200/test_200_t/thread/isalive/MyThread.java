package com.spring_101_200.test_191_200.test_200_t.thread.isalive;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("run = " + this.isAlive());
    }

    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        System.out.println("begin="+myThread.isAlive());
        myThread.start();


        Thread.sleep(1000l);
        System.out.println("end ==" + myThread.isAlive());
    }
}
