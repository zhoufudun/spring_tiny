package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1542;

public class Run {

    // 细化验证 3 个结论
    // synchronized(非this对象x)格式的写法是将x对象的本身作为"对象监视器"，这样就可以得出3个结论
    // 当多个线程同时执行synchronized(x){} 同步代码块时呈同步效果
    // 当其他的线程执行x 对象中synchronized同步方法时呈现同步效果
    // 当其他线程执行x 对象方法里面的synchronized(this)代码块时也呈现同步效果
    //
    public static void main(String[] args) throws Exception{
            MyOneList list = new MyOneList();
            MyThread1 thread1 = new MyThread1(list);
            thread1.setName("A");
            thread1.start();



        MyThread2 thread2 = new MyThread2(list);
        thread2.setName("B");
        thread2.start();
        Thread.sleep(6000);
        System.out.println("listSize = " + list.getSize());


    }

}
