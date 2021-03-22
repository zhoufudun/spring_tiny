package com.spring_1_100.test_61_70.test66_jdk_proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // 实例化目标对象
        UserService userService = new UserServiceImpl();
        // 实例化 invocationhandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();
        // 调用代理对象方法
        proxy.add();
    }
}
