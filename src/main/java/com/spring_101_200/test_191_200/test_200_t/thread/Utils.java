package com.spring_101_200.test_191_200.test_200_t.thread;

import com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1124.ThreadB;

public class Utils {

    public  static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public  static void sleepSeconds(long second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
