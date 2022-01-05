package com.spring_101_200.test_191_200.test_199_jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {


    interface IHello {
        void sayHello();
    }


    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("hello world");
        }
    }


    static class Dynamic implements InvocationHandler {
        Object orginalObj;


        Object bind(Object originObj) {
            this.orginalObj = originObj;
            return Proxy.newProxyInstance(originObj.getClass().getClassLoader(), originObj.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(orginalObj, args);
        }
    }


    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");


        IHello hello = (IHello) new Dynamic().bind(new Hello());
        hello.sayHello();
    }

}
