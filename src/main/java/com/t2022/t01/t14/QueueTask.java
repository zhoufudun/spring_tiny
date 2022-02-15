package com.t2022.t01.t14;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.CountDownLatch;

public class QueueTask implements Runnable {

    private CountDownLatch countDownLatch;

    public QueueTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始在医院药房排除买药...");
            Utils.sleep(5000);
            System.out.println("排队成功，可以开始缴费买药");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(countDownLatch !=null){
                countDownLatch.countDown();
            }
        }
    }
}
