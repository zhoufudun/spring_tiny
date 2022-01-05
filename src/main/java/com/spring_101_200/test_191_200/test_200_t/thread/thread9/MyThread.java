package com.spring_101_200.test_191_200.test_200_t.thread.thread9;

public class MyThread extends Thread {

    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }


    @Override
    public void run() {
        while (true) {
            i++;
        }
    }


    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(5000);
        //  A 段
        thread.suspend();
        System.out.println("A = " + System.currentTimeMillis() + " i = " + thread.getI());
        Thread.sleep(5000);
        System.out.println(" A = " + System.currentTimeMillis() + " i = " + thread.getI());

        // B段
        thread.resume();
        Thread.sleep(5000);

        // C 段
        thread.suspend();
        System.out.println("B = " + System.currentTimeMillis() + " i = " + thread.getI());
        Thread.sleep(5000);
        System.out.println("B = " + System.currentTimeMillis() + " i = " + thread.getI());

    }
}
