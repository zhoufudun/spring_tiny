package com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.client;

import com.spring_1_100.test_71_80.test76_spring_rmi.myrmi.service.MyRmiInvocationHandler;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.remoting.RemoteConnectFailureException;
import org.springframework.remoting.support.RemoteInvocation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public class MyRmiClientInterceptor implements MethodInterceptor {

    private Remote cachedStub;

    public MyRmiClientInterceptor(Remote remote) {
        this.cachedStub = remote;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        try {
            return ((MyRmiInvocationHandler) cachedStub).invoke(new RemoteInvocation(invocation));
        } catch (RemoteConnectFailureException ex) {
            ex.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
