package com.spring_101_200.test_191_200.test_200_t.thread.thread6;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("i = " + i);
            }


            this.stop();
            for (int i = 11; i < 20; i++) {
                System.out.println("i = " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
