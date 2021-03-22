package com.spring_1_100.test_61_70.test66_jdk_proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    // 目标方法
    private Object target;


    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        System.out.println("--------------before-----------------------");
        Object result = method.invoke(target, args);
        System.out.println("--------------after---------------------");
        return result;
    }

    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(),this);
    }
}
