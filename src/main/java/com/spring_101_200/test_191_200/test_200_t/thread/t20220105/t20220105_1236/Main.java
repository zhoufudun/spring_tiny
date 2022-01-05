package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1236;

public class Main {


    public int i =  10;

    synchronized  public void operateIMainMethod() {
        try {
            i --;
            System.out.println("main print i = " + i );
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
