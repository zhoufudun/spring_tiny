package com.t2022.t01.t15.t1712;

public class SynchronizedTest {

    public synchronized void test (){
        System.out.println(2 );
    }

    public static void main(String[] args)  throws Exception{

        SynchronizedTest synchronizedTest = new SynchronizedTest();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (synchronizedTest) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(1);
                }
            }
        });
        t1.start();
        Thread.sleep(100);
        synchronizedTest.test();


    }
}
// 打印顺序
// A  1,2   B 2,1  C 1,2 或2,1 都有可能 D 以上说法都不正确
