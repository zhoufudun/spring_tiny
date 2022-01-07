package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t0124;

public class MyRun {

    private String lock = new String();

    private Runnable runnableA = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("begin wait ");
                    lock.wait();
                    System.out.println("end wait ");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    private Runnable runnableB = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("begin notify ");
                    lock.notify();
                    System.out.println("end notify ");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


    public static void main(String[] args) throws Exception {
        MyRun myRun = new MyRun();


        Thread b = new Thread(myRun.runnableB);
        b.start();
        Thread.sleep(2000);



        Thread a = new Thread(myRun.runnableA);
        a.start();


    }

}
