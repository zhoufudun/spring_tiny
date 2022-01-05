package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1400;


public class TestRun {


    // 从此示例中可以看到，同步不能继承，所以还得在子类的方法中添加synchronized关键字，添加后的运行效果如下图所示
    public static void main(String[] args) {
        Sub subRef = new Sub();
        MyTheadA a = new MyTheadA(subRef);
        a.setName("A");
        a.start();

        MyTheadB b = new MyTheadB(subRef);
        b.setName("B");
        b.start();


    }
}
