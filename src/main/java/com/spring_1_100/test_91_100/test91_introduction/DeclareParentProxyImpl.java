package com.spring_1_100.test_91_100.test91_introduction;

import org.springframework.stereotype.Component;

@Component
public class DeclareParentProxyImpl implements IDeclareParentProxy{
    @Override
    public void declareParentProxy() {
        System.out.println("我是增强代理方法");
    }
}