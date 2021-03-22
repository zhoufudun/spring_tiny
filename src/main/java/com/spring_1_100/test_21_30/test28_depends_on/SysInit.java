package com.spring_1_100.test_21_30.test28_depends_on;

public class SysInit {

    public SysInit(){
        System.out.println("Sysinit 构造函数执行");
        SystemSettings.SESSION_TIMEOUT = 10;
        SystemSettings.REFRESH_CYCLE = 100;
    }


}
