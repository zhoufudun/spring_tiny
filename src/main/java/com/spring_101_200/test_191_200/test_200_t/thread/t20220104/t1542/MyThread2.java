package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1542;

public class MyThread2 extends Thread {

    private MyOneList list;


    public MyThread2(MyOneList list) {
        super();
        this.list = list;
    }


    @Override
    public void run() {
        super.run();
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "B");
    }
}
