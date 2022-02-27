package com.t2022.t01.t14;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest2 {


    static CyclicBarrier c = new CyclicBarrier(3, new A());

    public static void main(String[] args) throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();

        c.await();
        System.out.println(2);
    }

    static class  A implements Runnable{

        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
