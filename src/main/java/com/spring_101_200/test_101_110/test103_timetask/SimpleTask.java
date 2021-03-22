package com.spring_101_200.test_101_110.test103_timetask;

public class SimpleTask implements Runnable {

    private String taskName ;
    public SimpleTask(String taskName){
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println(" do " + taskName + " ... in Thread : " + Thread.currentThread().getId());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
