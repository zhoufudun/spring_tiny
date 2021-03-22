package com.spring_1_100.test_61_70.test65_5;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJTest {

    @Before("execution(* com.spring_1_100.test_61_70.test65_5.*.*(..)) && args(x,y)")
    public void beforeTest(String x, User y) {
        System.out.println("beforeTest x : " + x + "y : " + y);
    }

}
