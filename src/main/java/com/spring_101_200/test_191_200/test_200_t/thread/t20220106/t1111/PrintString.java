package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1111;

public class PrintString implements   Runnable {


    private boolean isContinuePrint = true;


    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean continuePrint) {
        isContinuePrint = continuePrint;
    }


    public void printStringMethod() {
        while (isContinuePrint) {
            System.out.println("run printStringMethod threadName = " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void run() {
        printStringMethod();
    }

    public static void main(String[] args) {
        PrintString printStringService = new PrintString();
       new Thread(printStringService).start();
        System.out.println("我要停止它 stopThread = " + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }






}
