package com.spring_101_200.test_191_200.test_200_t.thread.thread4;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for(int i = 0 ;i < 100000;i ++){
                Thread.sleep(2);
                System.out.println("i = " + i );
            }
            System.out.println("run end ");
           // Thread.sleep(20);
            System.out.println("run end ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
        System.out.println("end !");
    }
}
