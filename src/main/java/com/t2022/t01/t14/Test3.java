package com.t2022.t01.t14;

public class Test3 {

    public static void testA() {
        Integer i = 1;
        synchronized (i) {
            try {
                System.out.println("aaaaaaaaaaaaaaa start ");                           //1
                Thread.sleep(2000);
                System.out.println("aaaaaaaaaaaa end ");                                        //2
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testB() {
        Integer i = 1;
        synchronized (i) {
            try {
                System.out.println("bbbbbbbbbbbbbb start ");                       //3
                Thread.sleep(2000);
                System.out.println("bbbbbbbbbbbbbb end ");                          //4
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception{
        new Thread(new Runnable() {
            @Override
            public void run() {
                testA();
            }
        }).start();
        Thread.sleep(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                testB();
            }
        }).start();
    }

}
