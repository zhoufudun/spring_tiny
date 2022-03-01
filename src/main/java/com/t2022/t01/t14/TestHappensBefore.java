package com.t2022.t01.t14;

public class TestHappensBefore {


    public static int a = 1;

    public static void main(String[] args) {


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 打印变量A的值
                System.out.println(a);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 2;
                t1.start();
            }
        });
        t2.start();
    }
}
