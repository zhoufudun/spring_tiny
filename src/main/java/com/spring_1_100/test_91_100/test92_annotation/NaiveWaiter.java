package com.spring_1_100.test_91_100.test92_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class NaiveWaiter implements Waiter {
    @NeedTest
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + " ... ");
    }

    @Override
    public void serviceTo(String name) {
        System.out.println("serving " + name + " ... ");
    }


}
