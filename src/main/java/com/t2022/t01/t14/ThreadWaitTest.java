package com.t2022.t01.t14;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class ThreadWaitTest {

    public static void main(String[] args)  throws Exception{
        Integer a = new Integer(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    long startTime = System.currentTimeMillis();
                    try {
                        a.wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end time = " +(System.currentTimeMillis() - startTime));
                }
            }
        }).start();

       Thread.sleep(1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
              synchronized (a){
                  try {
                      Thread.sleep(4000);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }
            }
        }).start();
    }
}
