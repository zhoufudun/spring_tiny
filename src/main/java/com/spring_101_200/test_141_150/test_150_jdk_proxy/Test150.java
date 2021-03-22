package com.spring_101_200.test_141_150.test_150_jdk_proxy;

public class Test150 {

    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService helloService =(HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        helloService.sayHello("张三");
    }
}
