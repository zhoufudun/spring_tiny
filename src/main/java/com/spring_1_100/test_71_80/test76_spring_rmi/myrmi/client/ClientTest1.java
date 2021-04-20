package com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.client;

import com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.MyHelloRMIService;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.util.ClassUtils;

import java.rmi.Naming;
import java.rmi.Remote;

public class ClientTest1 {

    public static void main(String[] args) throws Exception {
        Remote remoteObj = Naming.lookup("rmi://127.0.0.1:9999/helloRMI");
        MyHelloRMIService serviceProxy = (MyHelloRMIService) new ProxyFactory(MyHelloRMIService.class,
                new MyRmiClientInterceptor(remoteObj)).getProxy(ClassUtils.getDefaultClassLoader());
        int c = serviceProxy.getAdd(1, 2);
        System.out.println(c);

    }

}
