package com.spring_1_100.test_91_100.test92_annotation;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class TestAspect {


    @Before("@annotation(com.spring_1_100.test_91_100.test92_annotation.NeedTest)")
    public void before(){

    }


    @AfterReturning("@annotation(com.spring_1_100.test_91_100.test92_annotation.NeedTest)")
    public void needTestFun(){
        System.out.println("aftering ");
    }

}
