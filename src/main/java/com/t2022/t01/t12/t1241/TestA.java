package com.t2022.t01.t12.t1241;

public class TestA implements InterfaceA, InterfaceB {


    public void TestA(){
        System.out.println("b");
    }


    @Override
    public void test2() {

    }


    public static void main(String[] args) {
        InterfaceA.test();
        TestA testA = new TestA();
    }
}
