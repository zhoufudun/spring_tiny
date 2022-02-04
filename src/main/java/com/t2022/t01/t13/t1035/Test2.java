package com.t2022.t01.t13.t1035;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class Test2 {


    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("hello world ");
                    Utils.sleep(30000);
                }catch (Exception e ){
                    e .printStackTrace();
                }finally {
                    System.out.println("finaly 块执行");
                }
            }
        });
        t.start();

        Utils.sleep(1000);
        t.interrupt();

    }



}
