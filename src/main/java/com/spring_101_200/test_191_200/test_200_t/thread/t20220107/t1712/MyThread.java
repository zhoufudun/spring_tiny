package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1712;

public class MyThread extends Thread {


    @Override
    public void run() {
        try {
            int secondValue = ((int) Math.random() * 10000);
            System.out.println(secondValue);
            Thread.sleep(secondValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();


        System.out.println("我想当threadTest对象执行完毕后再执行");
        System.out.println("但上面的代码sleep()中的值应该写多少呢？");
        System.out.println("答案是：根本不能确定");


    }



}
