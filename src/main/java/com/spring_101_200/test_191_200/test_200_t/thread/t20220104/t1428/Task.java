package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1428;

public class Task {


    private String getData1;
    private String getData2;

    public void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String privateGetData1 = "长时间处理任务后从远程返回的值1 ThreadName = " + Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务后从远程返回的值2 ThreadName = " + Thread.currentThread().getName();
            synchronized (this) {
                getData1 = privateGetData1;
                getData2 = privateGetData2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
