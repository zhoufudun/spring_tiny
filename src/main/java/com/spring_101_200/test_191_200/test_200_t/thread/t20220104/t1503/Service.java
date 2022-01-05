package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1503;


public class Service {
    // 多个线程调用同一个对象的不同名称的synchronized同步方法或synchronized(this)同步代码块时，调用的效果就是按顺序执行，也就是同步阻塞的
    // 这说明 synchronized同步方法或synchronized(this)同步代码块分别有两种作用

    // 1.synchronized同步方法
// 1) 对其他的synchronized同步方法或synchronized(this)同步代码块调用呈阻塞状态
// 2. 同一时间，只有一个线程可以执行synchronized同步方法中的代码 。
// (2) synchronized(this)同步代码块
// 1）对其他的synchronized同步方法或synchronized(this)同步代码块调用呈阻塞状态
    // 2) 同一时间，只有一个线程可以执行synchronized(this)同步代码块中的代码 。
    // 在前面的学习中，使用synchronized(this)格式来同步代码块，其实java还支持任意对象作为对象监视器，来实现同步功能，这个任意对象
    // 大多数的实例变量及方法的参数，使用格式 为synchronized(非this对象 )
    // 根据前面对synchronized(this)同步代码块的作用总结可知，synchronized(非this对象)格式的作用只有1种：synchronized(非this对象x)同步代码块
    // 1) 在多个线程持有"对象监视器"为同一个对象的前提下，同一时间只有一个线程可以执行synchronized(非this对象x)同步代码块中的代码 。





    private String usernameParam;
    private String passwordParam;
    private String anyString = new String();

    public void setUsernameParam(String username,String password ){
        try {
            synchronized (anyString){
                System.out.println("线程名称 " + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + " 进入同步块");
                usernameParam = username;
                Thread.sleep(3000);
                passwordParam =password;
                System.out.println("线程名称为：" + Thread.currentThread().getName() + " 在 " + System.currentTimeMillis() + "  离开同步块 " );
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
