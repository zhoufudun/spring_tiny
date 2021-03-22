package com.spring_101_200.test_151_160.test_151_cglib_proxy;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
