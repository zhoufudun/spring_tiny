package com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.client;

import com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.MyRemoteInvocation;
import com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.service.MyRmiInvocationHandler;

import java.rmi.Naming;
import java.rmi.Remote;

public class ClientTest1 {

    public static void main(String[] args) throws Exception {
        Remote remoteObj = Naming.lookup("rmi://127.0.0.1:9999/helloRMI");
        MyRemoteInvocation invocation = new MyRemoteInvocation();
        invocation.setArguments(new Object[]{1, 2});
        invocation.setMethodName("getAdd");
        invocation.setParameterTypes(new Class[]{int.class, int.class});
        Object object = ((MyRmiInvocationHandler) remoteObj).invoke(invocation);
        System.out.println(object);
    }

}
