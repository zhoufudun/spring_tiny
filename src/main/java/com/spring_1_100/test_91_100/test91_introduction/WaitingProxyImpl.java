package com.spring_1_100.test_91_100.test91_introduction;

import org.springframework.stereotype.Component;

@Component
public class WaitingProxyImpl implements IWaitingProxy {
    @Override
    public void method() {
        System.out.println("现有方法");
    }
}