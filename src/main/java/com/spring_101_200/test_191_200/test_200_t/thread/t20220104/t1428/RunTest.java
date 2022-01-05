package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1428;


public class RunTest {

    // 程序运行之后，大约耗时6秒
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        MyThread1 thread1 = new MyThread1(task);
        thread1.start();

        MyThread2 thread2 = new MyThread2(task);
        thread2.start();

        Thread.sleep(10000);


        long beginTime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1) {
            beginTime = CommonUtils.beginTime2;
        }

        long endTime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1) {
            endTime = CommonUtils.endTime2;
        }

        System.out.println("耗时：" + (endTime - beginTime) / 1000);
    }
}
