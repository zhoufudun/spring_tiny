package com.spring_1_100.test_71_80.test76_spring_rmi;

import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public interface HelloRMIService {
    int getAdd(int a, int b);
}
