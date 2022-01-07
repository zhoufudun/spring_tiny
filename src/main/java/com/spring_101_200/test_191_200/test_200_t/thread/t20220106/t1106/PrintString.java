package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1106;

public class PrintString {


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


    public static void main(String[] args) {
        PrintString printStringService = new PrintString();
        printStringService.printStringMethod();
        System.out.println("我要停止它 stopThread = " + Thread.currentThread().getName());
        printStringService.setContinuePrint(false);
    }
}
