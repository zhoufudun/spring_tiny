package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1156;

public class Service {
    private boolean isContinueRun = true;

    public void runMethod() {
        String aynString = new String();
        while (isContinueRun) {
            synchronized (aynString) {

            }
        }
        System.out.println("停下来了");
    }

    public void stopMethod() {
        isContinueRun = false;
    }


}
