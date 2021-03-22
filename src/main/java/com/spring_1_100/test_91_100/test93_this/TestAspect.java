package com.spring_1_100.test_91_100.test93_this;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect {

    @AfterReturning("this(com.spring_1_100.test_91_100.test93_this.Seller)")
    private void thisTest() {
        System.out.println(" thisTest() executed ! ");
    }
}
