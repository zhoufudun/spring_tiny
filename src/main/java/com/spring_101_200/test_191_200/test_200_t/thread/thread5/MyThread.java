package com.spring_101_200.test_191_200.test_200_t.thread.thread5;

public class MyThread extends Thread {


    private int i = 0;

    @Override
    public void run() {
        try {
            super.run();
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(8000);
        myThread.stop();
    }
}
