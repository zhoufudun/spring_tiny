package com.t2022.t01.t12.t1152;



public class TestB extends TestA {

    // Java程序执行子类的构造方法之前，如果没有用super()来调用父类的特定的构造方法，则会调用父类中"没有参数的构造方法"，因此，如果父类中只
    // 定义了有参数的构造方法，而在子类的构造方法中又没有用super()来调用特定的构造方法，则编译时将发生错误，因为，Java程序在父类中找不到
    // 没有参数的构造方法可供执行，解决办法是在父类里加上一个不做事且没有参数的构造方法。
    public TestB(String a) {
        super(a);
    }



}