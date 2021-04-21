package com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.service;

import com.spring_1_100.test_71_80.test76_spring_rmi.HelloRMIServiceImpl;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerTest1 {

    public static void main(String[] args) throws Exception {
        int registryPort = 9999;
        Registry reg = LocateRegistry.createRegistry(registryPort);
        Remote exportedObject = new MyRmiInvocationWrapper(new HelloRMIServiceImpl());
        UnicastRemoteObject.exportObject(exportedObject, 0);
        reg.bind("helloRMI", exportedObject);
    }
}
