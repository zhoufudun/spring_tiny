package com.spring_101_200.test_191_200.test_200_t.thread.t20220110_single.t0957;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class MyObject2 {

    private static MyObject2 myObject;

    private MyObject2() {

    }

    // 设置同步方法的效率太低了
    // 整个方法被上锁
    public static MyObject2 getInstance() {
        Utils.sleep(3000);
        synchronized (MyObject2.class) {
            if (myObject == null) {
                // 模拟在创建对象之前做一些准备工作
                myObject = new MyObject2();
            }
        }
        return myObject;
    }


    // 此方法的加入是同步 synchronized语句块得到相同的实例对象，但是此种方法的运行效率也是非常低的，和synchronized同步方法一样的是同步运行的，继续更改代码深度解决
    // 这个缺点
    // 针对某些重要的代码进行单独的同步
    // 同步代码块可以针对某些重要的代码进行单独的同步，而其他的代码则不需要同，这样的运行时，效率完全可以得到大幅度的提升

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(MyObject2.getInstance().hashCode());
                }
            }).start();
        }
    }
}
