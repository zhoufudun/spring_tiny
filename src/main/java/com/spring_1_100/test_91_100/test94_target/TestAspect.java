package com.spring_1_100.test_91_100.test94_target;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {

    @AfterReturning("target(com.spring_1_100.test_91_100.test94_target.Seller)")
    private void thisTest() {
        System.out.println(" thisTest() executed ! ");
    }
}
