package com.spring_101_200.test_141_150.test_150_jdk_proxy;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
