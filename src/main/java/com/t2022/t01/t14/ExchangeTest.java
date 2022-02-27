package com.t2022.t01.t14;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangeTest {

    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A"; // A录入银行流水数据
                    exgr.exchange(A);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";//B 录入银行流水数据
                    String a = exgr.exchange("B");
                    System.out.println("A和B数据是否一致:" + a.equals(B) + ",A的录入数据是:" + a + " ，B的录入数据是:" + B);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();


    }
}
