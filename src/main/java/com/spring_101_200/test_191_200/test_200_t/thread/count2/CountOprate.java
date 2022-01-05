package com.spring_101_200.test_191_200.test_200_t.thread.count2;



public class CountOprate extends Thread {
    public CountOprate() {
        System.out.println("CountOprate ---begin");
        System.out.println("Thread.currentThread.getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()==" + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("CountOprate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" + Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("run---end");
    }

    public static void main(String[] args)  throws Exception{
        CountOprate c = new CountOprate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + t1.isAlive());
        t1.setName("A");
        t1.start();

        Thread.sleep(5000l);
        System.out.println("main end t1 isAlive=" + t1.isAlive());
    }
}
