package com.spring_1_100.test_21_30.test25_lookup_method;

import org.springframework.context.ApplicationContext;

public class MagicBossImpl implements MagicBoss {

    private ApplicationContext ctx;

    @Override
    public Car getCar() {
        return (Car) ctx.getBean("car");
    }
}
