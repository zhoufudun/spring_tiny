package com.t2022.t01.t14;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

import java.util.concurrent.CountDownLatch;

public class SeeDoctorTask implements Runnable {

    private CountDownLatch countDownLatch;

    public SeeDoctorTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("开始看医生");
            Utils.sleep(3000);
            System.out.println("结束看医生，准备离开病房");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(countDownLatch !=null){
                countDownLatch.countDown();
            }
        }
    }
}
