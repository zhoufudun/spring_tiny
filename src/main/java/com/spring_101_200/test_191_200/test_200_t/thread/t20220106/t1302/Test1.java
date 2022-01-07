package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1302;

public class Test1 {





    //方法wait()的作用是使用当前执行代码的线程进行等待，wait()方法是Object类的方法，该方法用来将当前线程置入（预执行的队列中），并且在wait()
    // 所在的代码行处停止执行，直到接到通知或被中断为止，在调用wait()之前，线程必须获得该对象的对象级别锁，即只能在同步方法中或同步块中
    // 调用wait()方法，在执行wait()方法后，当前线程释放锁，在从wait()返回前，线程与其他线程竞争重新获取锁，如果调用wait()时没有持有适当的
    // 锁，则抛出IllegalMonitorStateException ，它是RuntimeException的一个子类，因此不需要try-catch语句进行捕捉异常。
    // 方法notify()也要在同步方法或同步块中调用，即在调用前，线程也必须获得该对象的对象级锁，如果调用notify()时没有持有适当的锁。
    // 也会抛出IllegalMonitorStateException ， 该方法用来通知那些可能等待该对象的对象锁的其他线程，如果有多个线程等待。
    // 则由线程规划器随机挑选出其中一个呈wait状态的线程，对其发出通知notify，并使它等待获取该对象的对象锁，需要说明的是，在执行
    // notify()方法后，当前线程不会马上释放该对象锁，呈wait()状态的线程也并不能马上获取该对象锁，要等到执行notiry()方法的线程将程序执行完
    // 也就是退出 synchronized代码块之后，当前线程才会释放锁，而呈wait状态所在的线程才可以获取该对象锁，当第一个获得该对象锁的wait
    // 线程执行完毕后，它会释放掉该对象锁，此时如果该对象没有再次使用notify语句，则即使该对象已经空闲，其他wait状态等待的线程由于没有
    //得到该对象的通知，还会继续阻塞在wait状态，直到这个对象发出一个notify或notifyAll()
    // 用一句话来总结一下，wait和notify ：wait命名线程停止运行，而notify使停止的线程继续运行。

    public static void main(String[] args) throws Exception{
        String newString = new String("");
        newString.wait();
    }
}
