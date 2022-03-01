package com.t2022.t01.t14;

public class DoubleCheckLock {

    private static DoubleCheckLock instance;

    private DoubleCheckLock() { }

    public static DoubleCheckLock getInstance() {
        // 第一次检测
        if (instance == null) {
            // 同步
            synchronized (DoubleCheckLock.class) {
                // 多线程环境下可能会出现问题的地方
                instance = new DoubleCheckLock();
            }
        }
        return instance;
    }
}
