package com.t2022.t01.t14;

public class SynchronizedDemo2 {

    public synchronized void method(){
        System.out.println("synchronized 方法");
    }

    // synchronized修饰的方法并没有monitorenter指令和monitoreexit指令，取得代之确实是ACC_SYNCHRONIZED 标识，
    // 该标识指明了该方法是一个同步方法，JVM 通过该ACC_SYNCHRONIZED 访问标志来辨别一个方法是否声明为同步方法，从而执行相应的同步调用 。
    // volatile关键字的主要作用就是保证变量的可见性然后还有一个作用就是防止指令重排序
    // 并发
    public static void main(String[] args) {

    }
}
