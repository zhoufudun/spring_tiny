package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t0957;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class MyObject {

    private static MyObject myObject;

    private MyObject() {

    }

    // 设置同步方法的效率太低了
    // 整个方法被上锁
    synchronized public static MyObject getInstance() {
        if (myObject == null) {
            // 模拟在创建对象之前做一些准备工作
            Utils.sleep(3000);
            myObject = new MyObject();
        }
        return myObject;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(MyObject.getInstance().hashCode());
                }
            }).start();
        }
    }
}
