package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1330;

public class Service {

    public void testA() {
        synchronized (this) {
            try {
                System.out.println("testA方法开始等待" + System.currentTimeMillis());
                this.wait();
                System.out.println("TestA方法执行完成" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testB() {
        synchronized (this) {
            try {
                System.out.println("testB 方法notify() " + System.currentTimeMillis());
                this.notify();
                Thread.sleep(2000);
                System.out.println("testB 方法睡2秒后执行" + System.currentTimeMillis());
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



        Thread.sleep(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                service.testB();
            }
        }).start();
    }


}
