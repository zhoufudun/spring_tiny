package com.t2022.t01.t14;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class SyncA {

    public static synchronized void  a(){
        System.out.println(" SyncA a 方法结束");
        Utils.sleep(2000);
        System.out.println(" SyncA a 方法结束");
    }
}
