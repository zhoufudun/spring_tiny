package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t0957;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class MyObject3 {

    private static MyObject3 myObject;

    private MyObject3() {

    }

    // 设置同步方法的效率太低了
    // 整个方法被上锁
    public static MyObject3 getInstance() {
        Utils.sleep(3000);
        if (myObject == null) {
            synchronized (MyObject3.class) {
                if (myObject == null) {
                    // 模拟在创建对象之前做一些准备工作
                    myObject = new MyObject3();
                }
            }
        }
        return myObject;
    }

// 双重检查锁功能，成功的解决了 "懒汉模式 " ，遇到多线程问题，DCL 也是大多数线程结合单例模式的解决方案
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(MyObject3.getInstance().hashCode());
                }
            }).start();
        }
    }
}
