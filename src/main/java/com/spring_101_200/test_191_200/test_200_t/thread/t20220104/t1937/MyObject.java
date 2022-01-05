package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1937;

public class MyObject {


    synchronized public void speedPrintString() {
        synchronized (this){
            System.out.println("speedPrintString _______getLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread().getName());
            System.out.println("--------------------");
            System.out.println("speedPrintString releaseLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread().getName());
        }
    }





    public void speedPrintString1() {
      synchronized (this){  System.out.println("speedPrintString _______getLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread().getName());
          System.out.println("--------------------");
          System.out.println("speedPrintString releaseLock time = " + System.currentTimeMillis() + " run ThreadName = " + Thread.currentThread().getName());
      }
    }

}
