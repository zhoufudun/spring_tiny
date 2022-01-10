package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1131;

public class MyThread extends Thread {


    // 但是将main方法中的代码改成了使用sleep(2000)方法时，运行的效果还是等待了2秒
    // 那使用join(2000)和使用sleep(2000)秒有什么区别呢？上面的示例中的运行效果上并没有区别，其实区别还主要还是处于2个方法的同步原理上

    @Override
    public void run() {
        try {
            System.out.println("begin Timer = " + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("begin timer = " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        MyThread thread = new MyThread();
        thread.start();

        thread.join(2000);


        System.out.println(" end timer = " + System.currentTimeMillis());
    }

}
