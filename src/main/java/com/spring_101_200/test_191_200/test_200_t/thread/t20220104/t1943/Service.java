package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1943;

public class Service {

    synchronized public static void printA() {
        try {
            System.out.println("线程名 ：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入printA ");
            Thread.sleep(3000);
            System.out.println("线程名 ：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 离开printA ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    synchronized public static void printB(){
        System.out.println("线程名称 ：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入PrintB ");
        System.out.println("线程名称 ：" + Thread.currentThread().getName()  + " 在 " + System.currentTimeMillis() + " 离开PrintB ")  ;
    }




}
