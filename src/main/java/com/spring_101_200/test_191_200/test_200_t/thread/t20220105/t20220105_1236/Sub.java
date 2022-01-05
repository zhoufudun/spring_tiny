package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1236;

public class Sub extends Main {

    synchronized  public void operateISubMethod(){
        try {
            while( i > 0 ){
                i --;
                System.out.println("sub print i = " + i );
                Thread.sleep(100);
                this.operateIMainMethod();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
