package com.spring_1_100.test_71_80.test77_spring_httpinvoker.service;

public class HttpInvokerTestImpl implements HttpInvokerTestI {
    @Override
    public String getTestPo(String desp) {

        return "getTestPo " + desp;
    }
}
