package com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.service;

import com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.MyHelloRMIService;
import com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.MyHelloRMIServiceImpl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.util.ClassUtils;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerTest1 {

    public static void main(String[] args) throws Exception {
        int registryPort = 9999;
        Registry reg = LocateRegistry.createRegistry(registryPort);
        Remote exportedObject = new MyRmiInvocationWrapper(getProxyForService());
        UnicastRemoteObject.exportObject(exportedObject, 0);
        reg.bind("helloRMI", exportedObject);
    }

    public static Object getProxyForService() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addInterface(MyHelloRMIService.class);
        proxyFactory.addAdvice(new MyRemoteInvocationTraceInterceptor());
        proxyFactory.setTarget(new MyHelloRMIServiceImpl());
        proxyFactory.setOpaque(true);
        return proxyFactory.getProxy(ClassUtils.getDefaultClassLoader());
    }

}
