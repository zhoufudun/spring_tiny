package com.spring_1_100.test_61_70.test67_cglib_proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EnhancerDemo1 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(EnhancerDemo1.class);
        enhancer.setCallback(new MethodInterceptorImpl( new EnhancerDemo1()));
        EnhancerDemo1 demo = (EnhancerDemo1) enhancer.create();
        demo.test();
        System.out.println(demo);
    }


    public void test() {
        System.out.println("EnhancerDemo test ");
    }


    private static class MethodInterceptorImpl implements MethodInterceptor {
        private Object target ;

        private MethodInterceptorImpl(Object target){
            super();
            this.target = target;
        }

        @Override
        public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            System.out.println("before invoke :" + method);
            //Object result = methodProxy.invokeSuper(o, args);
            Object result = methodProxy.invoke(target, args);
            System.out.println("after invoke " + method);
            return result;
        }
    }
}
