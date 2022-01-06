package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1047;

public class ThreadB extends Thread {

    private Service service;

    private UserInfo userInfo;


    public ThreadB(Service service, UserInfo userInfo) {
        super();
        this.service = service;
        this.userInfo = userInfo;
    }


    @Override
    public void run() {
        super.run();
        service.serviceMethodA(userInfo);
    }
}
