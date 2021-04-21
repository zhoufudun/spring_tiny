package com.spring_1_100.test_71_80.test76_spring_rmi;

import com.spring_101_200.test_141_150.test_150_jdk_proxy.HelloService;
import org.springframework.beans.factory.FactoryBean;

public class HelloRMIServiceRemoteInterfaceSelectorImpl implements FactoryBean<Object> {

    private RoundRobinStrategy roundRobinStrategy;

    @Override
    public Object getObject() throws Exception {
        return roundRobinStrategy.getService();
    }


    @Override
    public Class<?> getObjectType() {
        return HelloService.class;
    }

    @Override
    public boolean isSingleton() {

        return true;
    }

    public RoundRobinStrategy getRoundRobinStrategy() {
        return roundRobinStrategy;
    }

    public void setRoundRobinStrategy(RoundRobinStrategy roundRobinStrategy) {
        this.roundRobinStrategy = roundRobinStrategy;
    }
}
