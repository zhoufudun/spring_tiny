package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1943;

public class TestA {


    public  static void  testA(){
        Integer i = 1;
        synchronized (i){
            try {
                System.out.println("aaaaaaaaaaaaaaa start ");
                Thread.sleep(2000);
                System.out.println("aaaaaaaaaaaa end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public  static void  testB(){
        Integer i = new Integer(1);
        synchronized (i){
            try {
                System.out.println("bbbbbbbbbbbbbb start " );
                Thread.sleep(2000);
                System.out.println("bbbbbbbbbbbbbb end ");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                testA();
            }
        })      .start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testB();
            }
        }).start();


    }
}
