package com.t2022.t01.t14;

public class HappensBeforeJoin {

    public static int i =0 ;
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                i  = 2 ;
            }
        });
        t.start();
        t.join();
        System.out.println(i);


    }
}
