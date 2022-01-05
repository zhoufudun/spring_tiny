package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t2256;

public class Service {

    public static void printA() {
        try {
            synchronized (Service.class) {
                System.out.println("线程名称为：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入Print A ");
                Thread.sleep(3000);
                System.out.println("线程名称为：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 离开A ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void printB() {
        synchronized (Service.class) {
            System.out.println("线程名称为：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入PrintB ");
            System.out.println("线程名称为：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 离开PrintB ");
        }
    }
}
