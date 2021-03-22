package com.spring_1_100.test_61_70.test64;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
@Aspect*/
public class BeforeTest {

    //@Pointcut("execution(* com.spring_1_100.test_61_70.test64.*.*(..))")
    public void before() {

    }

    //@Before("before()")
    public void beforeTest() {
        System.out.println("BeforeTest.beforeTest");
    }


}
