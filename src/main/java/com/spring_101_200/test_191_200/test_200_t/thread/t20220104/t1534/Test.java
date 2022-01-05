package com.spring_101_200.test_191_200.test_200_t.thread.t20220104.t1534;

public class Test {


    public static void main(String[] args) {
        MyList myList = new MyList();
        MyThreadA a = new MyThreadA(myList);
        a.setName("A");
        a.start();


        MyThreadB b = new MyThreadB(myList);
        b.setName("B");
        b.start();
    }
}
