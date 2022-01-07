package com.spring_101_200.test_191_200.test_200_t.thread.t20220107.t1657;

public class DBTools  {
    volatile  private  boolean prevIsA = false;

    synchronized  public void backupA(){
        try {
            while (prevIsA ){
                wait();
            }
            for(int i = 0 ;i < 5 ;i ++){
                System.out.println("*****");
            }
            prevIsA = true;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    synchronized  public void backupB(){
        try {
            while (!prevIsA){
                wait();
            }

            for(int i = 0 ;i < 5 ;i ++){
                System.out.println("~~~~~");
            }
            prevIsA = false;
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}
