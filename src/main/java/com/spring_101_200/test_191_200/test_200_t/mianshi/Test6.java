package com.spring_101_200.test_191_200.test_200_t.mianshi;

public class Test6 {

    public static int flag = 0;

    public synchronized static   void f1() {
        System.out.println("+++++++" + flag);
        flag = flag + 1;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void f2() {
        flag--;
    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    f1();
                }
            }).start();
        }


        Thread.sleep(5000l);
        System.out.println(flag);
    }
}

