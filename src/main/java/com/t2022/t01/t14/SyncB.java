package com.t2022.t01.t14;

import com.spring_101_200.test_191_200.test_200_t.thread.Utils;

public class SyncB {

    // 对于普通同步方法，锁是当前实例对象
    // 对于静态同步方法，锁是当前类的Class对象
    // 对于同步方法块，锁是Synchonized括号里配置的对象
    public void b(SyncA a) {
        synchronized (a) {
            System.out.println("SyncB b 方法开始");

            System.out.println("SyncB b 方法结束");
        }
    }

    public static void main(String[] args) {
        SyncA a = new SyncA();
        SyncB b = new SyncB();

        new Thread(new Runnable() {
            @Override
            public void run() {
                a.a();
            }
        }).start();


        Utils.sleep(100);
        new Thread(new Runnable() {
            @Override
            public void run() {
                b.b(a);
            }
        }).start();
    }
}
