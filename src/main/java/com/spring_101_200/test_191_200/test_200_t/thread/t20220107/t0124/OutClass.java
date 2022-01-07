package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t0124;

public class OutClass {

    public void a () {
        try {
            System.out.println("a 方法开始 ");
            Thread.sleep(2000);
            System.out.println("a 方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void b () {
        try {
            System.out.println("b 方法开始 ");
            Thread.sleep(2000);
            System.out.println("b 方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        OutClass o = new OutClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                o.a();
            }
        }).start();

        Thread.sleep(2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                o.b();
            }
        }).start();


    }
}
