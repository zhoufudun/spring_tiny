package com.spring_1_100.test_61_70.test67_cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo.class);
        enhancer.setCallback(new MethodInterceptorImpl());
        EnhancerDemo demo = (EnhancerDemo) enhancer.create();
        demo.test();
        //System.out.println(demo);
    }


    public void test() {
        System.out.println("EnhancerDemo test ");
        test1();
    }

    public void test1() {
        System.out.println("EnhancerDemo test1 ");
    }


    private static class MethodInterceptorImpl implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("before invoke :" + method);
            Object result = methodProxy.invokeSuper(o, args);
            System.out.println("after invoke " + method);
            return result;
        }
    }
}
