package com.spring_101_200.test_191_200.test_200_t.thread.t20220108.t1623;

import org.apache.tools.ant.types.resources.FileResourceIterator;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    // 关键字synchronized与wait()和notify() / notifyAll() 方法相结合可以实现等待，通过模式类ReentrantLock也可以实现同样的功能
    // 但是需要借助于Condition对象，Condition类是JDK5中出现的技术，使用它可以有更好的灵活性，比如可以实现多路通知功能，Condition类
    // 从而可以选择性的线程通知，在调度线程上更加灵活
    // 在使用notify()和notifyAll()方法进行通知时，被通知的线程却是由JVM 随机选择的，但使用ReentrantLock结合Condition类是可以实现前面
    // 介绍过的，选择性通知，这个功能非常重要，而且Condition类中默认提供的
    // 而synchronized就相当于整个Lock对象中只有一个单一的Condition对象，所有的线程都注册在它一个对象的身上，线程开始notifyAll() 时
    // 需要通知所有的人WAITING线程，没有选择权，会出现相当大的效率问题


    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    //     // Exception in thread "Thread-0" java.lang.IllegalMonitorStateException
    public void await(){
        try {
            condition.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void waitMehtod(){
        try {
            lock.lock();
            System.out.println("A");
            condition.await();
            System.out.println("B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("锁被释放了");
        }
    }




    // 控制台只打印了一个字母A ,原因是调用了Condition对象的await()方法，使用当前执行任务的线程进入等待WAITING状态
    public static void main(String[] args) {

        MyService service = new MyService();
        new Thread(new Runnable() {
            @Override
            public void run() {
                service.waitMehtod();
            }
        }).start();
    }
}
