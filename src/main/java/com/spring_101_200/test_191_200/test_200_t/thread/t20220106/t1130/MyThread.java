package com.spring_101_200.test_191_200.test_200_t.thread.t20220106.t1130;

public class MyThread extends Thread {


    volatile public static int count;

    synchronized private  static void addCount() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        addCount();
    }

    // 如果在addCount()方法前面加上synchronized同步关键字，也就没有必要再使用volatile关键字来声明了
    // 关键字volatile主要使用的场合是在多个线程中可以感知实例变量被更改了，并且可以获取最新的值使用，也就是用多线程读取共享变量时可以获取最新的值使用
    // 关键字volatile提示线程每次从共享内存中读取变量，而不是从私有内存中读取，这样就保证了同步数据的可见性，但是这里需要注意的是，如果修改实例变量中的数据
    // 比如 i ++ ，也就是i = i + 1 ，则这样的操作其实并不是一个原子操作，也就是非线程安全的，表达式i ++ 的操作步骤分解如下 ：
    // 从内存中读取i 的值
    // 计算i 的值
    // 将i 的值写到内存中
    // 假如在第2步计算值的时候，另外一个线程也修改了i 的值，那么这个时候就会出现脏数据，解决的办法其实就是使用synchronized关键字。
    // 这个知识点的前面安全中已经介绍过，所以部volatile本身并不处理数据的原子性，而强制对数据读写及影响到主内存中。
    // 用图来演示一下使用关键字volatile时出现非线程安全的原因，变量在内存中工作过程如图 2-80所示 。
    // 由上 ，我们可以得出以下的结论
    // 1)read和load阶段，从主存中复制变量到当前线程工作内存
    // 2)use 和 assign阶段，执行代码，改变共享变量的值
    // 3)store和write阶段，用工作内存数据刷新主存对应变量的值
    // 在多线程环境中，use和assign是多次出现的，但这一操作并不是原子性的，也就是在read和load之后，如果主内存中的count变量发生修改之后，线程
    // 工作内存中的值由于已经加载，不会产生对应的变量，也就是私有内存和公共内存中的变量不同步，所以计算出来的结果和预期不一样，也就出现了非线程安全问题
    // 对于 volatile修饰的变量，JVM虚拟机只是保证从主内存加载到线程工作内存的值是最新的，例如线程1 和线程2 在进行read和load的操作中
    // 发现主内存中的count值都是5 ，那么都会加载这个最新的值，也就是说，volatile 关键字解决的是变量读时的可见性问题，但是无法保证原子 性
    // 对于多个线程访问同一个实例变量还是需要加锁同步的。

    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreads[i] = new MyThread();
        }
        for (int i = 0; i < 100; i++) {
            myThreads[i].start();
        }
    }
}
