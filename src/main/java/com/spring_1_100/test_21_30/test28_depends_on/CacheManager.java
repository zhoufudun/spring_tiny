package com.spring_1_100.test_21_30.test28_depends_on;

public class CacheManager {

    public CacheManager() {
        System.out.println("CacheManager 构造函数执行");
        System.out.println("SESSION_TIMEOUT  = " + SystemSettings.SESSION_TIMEOUT);
        System.out.println("REFRESH_CYCLE = " + SystemSettings.REFRESH_CYCLE);
    }
}
