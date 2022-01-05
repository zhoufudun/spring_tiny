package com.spring_101_200.test_191_200.test_200_t.thread.thread8;

public class MyThread extends Thread {


    @Override
    public void run() {
        while(true){
            if(this.isInterrupted()){
                System.out.println("停止了！");
                return;
            }
            System.out.println("timer = " + System.currentTimeMillis());
        }



    }

    public static void main(String[] args)  throws Exception{
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(2000);
        t.interrupt();
        
    }
}
