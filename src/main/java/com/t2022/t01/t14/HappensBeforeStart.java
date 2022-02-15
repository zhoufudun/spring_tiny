package com.t2022.t01.t14;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class HappensBeforeStart {

    public static int i = 1;

    public static void main(String[] args) {
        i = 2 ;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(i);
            }
        }).start();
        Utils.sleep(100);
        i = 3 ;
    }
}
