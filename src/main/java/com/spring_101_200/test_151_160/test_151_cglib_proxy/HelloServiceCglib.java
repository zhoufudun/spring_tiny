package com.spring_101_200.test_151_160.test_151_cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloServiceCglib implements MethodInterceptor {


    private Object target;

    //创建代理对象
    public Object getInstance(Object target) {

        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("#########这是CGLIB代理#############");
        //反射方法前调用
        System.out.println("我准备说hello");

        Object returnObj = methodProxy.invokeSuper(obj, args);
        //反射方法后调用
        System.out.println("我己经说Hello了");
        return returnObj;
    }
}
