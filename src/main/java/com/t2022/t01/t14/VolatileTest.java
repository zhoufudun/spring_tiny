package com.t2022.t01.t14;

public class VolatileTest {

    public static int i = 0;
    public static volatile int j = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                i = 1;
                j = 2;
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (j == 2) {
                    System.out.println(i);
                }
            }
        }).start();

    }
}

// A 0或1  B 1  C 1或不打印i的值   D 0或1或不打印i的值

