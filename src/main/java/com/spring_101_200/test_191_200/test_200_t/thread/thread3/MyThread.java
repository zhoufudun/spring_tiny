package com.spring_101_200.test_191_200.test_200_t.thread.thread3;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(2000000);
            System.out.println("run end ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(200);
        thread.interrupt();

        System.out.println("end !");
    }
}
