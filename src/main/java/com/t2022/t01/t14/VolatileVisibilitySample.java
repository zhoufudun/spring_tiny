package com.t2022.t01.t14;

public class VolatileVisibilitySample {

    volatile boolean initFlag = false;

    public void save() {
        this.initFlag = true;
        String threadName = Thread.currentThread().getName();
        System.out.println("线程：" + threadName + ": 修改共享变量initFlag ");
    }


    public void load() {
        String threadName = Thread.currentThread().getName();
        while (!initFlag) {
            //线程在此处窜，等待initFlag状态改变
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程：" + threadName + " 当前线程嗅探到initFlag的状态的改变");
    }


    public static void main(String[] args) {
        VolatileVisibilitySample sample = new VolatileVisibilitySample();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                sample.save();
            }
        }, "ThreadA");

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                sample.load();
            }
        }, "ThreadB");

        threadB.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadA.start();
    }
}
