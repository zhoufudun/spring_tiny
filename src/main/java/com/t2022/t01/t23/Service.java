package com.t2022.t01.t23;

public class Service {
        public void testA() {
            synchronized (this) {
                try {
                    System.out.println("testA方法开始等待" + System.currentTimeMillis());             // 1
                    this.wait();
                    System.out.println("TestA方法执行完成" + System.currentTimeMillis());             // 2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        public void testB() {
            synchronized (this) {
                try {
                    System.out.println("testB 方法notify() " + System.currentTimeMillis());       // 3
                      this.notify();
                    Thread.sleep(2000);
                    System.out.println("testB 方法睡2秒后执行" + System.currentTimeMillis());          // 4
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        public static void main(String[] args)  throws Exception{
            Service service = new Service();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.testA();
                }
            }).start();

            Thread.sleep(1000);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    service.testB();
                }
            }).start();
        }
    }
