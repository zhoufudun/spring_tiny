package com.spring_101_200.test_191_200.test_200_t.thread.interrupt;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i=" + (i + 1));
        }
    }

    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(2000);
        //myThread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("是否停止 1 ？="+myThread.isInterrupted());
        System.out.println("是否停止 1 ？="+myThread.isInterrupted());

    }
}
