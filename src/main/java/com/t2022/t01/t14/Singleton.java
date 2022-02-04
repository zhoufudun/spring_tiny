package com.t2022.t01.t14;

public class Singleton {

    private volatile static Singleton singleton;

    private Singleton() {

    }


    // 另外，需要注意的是 singleton采用volatile关键字修饰也是很有必要的， singleton 这段代码其实是分为三步来执行
    // 1.为singleton 分配内存空间
    // 2. 初始化 singleton
    // 3.将singleton指向分配的内存地址
    // 但是由于JVM 具有指令重排的特性，执行顺序有可能变成1-3-2 ，指令重排在间线程下是不会出现问题的，但是在多线程环境下会导致
    // 一个线程获得还没有初始化的实例，例如 ，线程T1 执行了1 和 3 ，此时 T2 调用getInstance() 后发现 single 不为空，因此返回
    // singleton ，但是singleton 还未被初始化
    // 使用volatile 可以禁止 JVM的指令生排序，保证在多线程环境下也能正常运行。
    // synchronized 同步语句块的实现使用的是monitorenter 和monitorexit指令，其中monitorenter指令指向同步代码块的开始位置 ，monitorexit指令
    // 则指明同步代码块的结束位置
    public synchronized static Singleton getInstance() {
        // 先判断对象是否已经实例过，没有实例化过进入加锁代码
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
