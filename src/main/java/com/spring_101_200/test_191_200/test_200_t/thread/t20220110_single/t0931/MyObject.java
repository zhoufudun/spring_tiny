package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t0931;

public class MyObject {


    // 立即加载方式 == 饿汉模式
    private static MyObject myObject = new MyObject();

    private MyObject() {

    }

    public static MyObject getInstance() {
        // 此代码版本为立即加载
        // 此版本代码的缺点是不能有其他实例变量
        // 因为getInstance() 方法没有同步
        // 所有可能出现非线程安全问题
        return myObject;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(MyObject.getInstance().hashCode());
                }
            }).start();
        }
    }
}
