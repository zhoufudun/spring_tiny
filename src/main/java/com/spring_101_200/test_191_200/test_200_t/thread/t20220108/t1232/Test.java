package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1232;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class Test {


    public static void main(String[] args) throws Exception {
        ThreadB b = new ThreadB();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Utils.sleep(5000);
                synchronized (b ) {
                    System.out.println(" begin A ThreadName = " + Thread.currentThread().getName() + " " + System.currentTimeMillis());

                    System.out.println("end A threadName=" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
                }
            }
        }).start();
        b.start();
        System.out.println(" 主线程运行");

        b.join(2000);

        System.out.println(" main end = " + System.currentTimeMillis());

    }


}
