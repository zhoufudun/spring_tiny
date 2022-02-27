package com.t2022.t01.t14;

public class JoinCountDownLatchTest {

    public static void main(String[] args) throws Exception {
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        parser1.start();
        parser2.start();

        parser1.join();
        parser2.join();
        System.out.println("all thread run finished");
    }

}
