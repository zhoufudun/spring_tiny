package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t0952;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class MyObject {

    private static MyObject myObject;

    private MyObject() {

    }

    // 此实验虽然取得一个对象的实例，但是如果在多多线程的环境中就会出现取出多个实例的情况，与童便模式的初衷是相背离的
    public static MyObject getInstance() {
        // 延迟加载
        if (myObject != null) {

        } else {
            Utils.sleep(200);
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
