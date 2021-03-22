package com.spring_101_200.test_141_150.test_150_jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxy implements InvocationHandler {

    //真实服务对象
    private Object target;

    //绑定委托的对象返回一个代理
    public Object bind(Object target){
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);

    }

    /**
     * 通过代理对象调用方法首先进入这个方法
     * @param proxy   代理对象
     * @param method   被调用的方法
     * @param args   方法参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("#############我是JDK动态代理################");
        Object result = null;
        //反射方法前调用
        System.out.println(method.getDeclaringClass());
        System.out.println(method.getName());
        System.out.println("我准备说Hello");
        //执行方法，相当于调用HelloServiceImpl的sayHello方法
        result = method.invoke(target,args);
        //反射方法后调用
        System.out.println("我说过Hello了");
        return result;
    }
}
