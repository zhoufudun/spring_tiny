package com.spring_101_200.test_191_200.test_200_t.thread.thread2;

public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        for(int i = 0 ;i < 50000;i ++){
            if(this.isInterrupted()){
                System.out.println("已经停止状态了，我要退出 ");
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("i = "+ (i + 1 ));
        }
    }

    public static void main(String[] args)  throws Exception{
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(2000l);
        thread.interrupt();
    }
}
