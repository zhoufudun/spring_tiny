package com.spring_101_200.test_191_200.test_200_t.thread.t20220105.t20220105_1207;

public class Service  {

    synchronized public void service1(){
        System.out.println("service1 ");
        service2();
    }
    synchronized public void service2(){
        System.out.println("service2 ");
        service3();
    }
    synchronized public void service3(){
        System.out.println("service3");
    }

}
