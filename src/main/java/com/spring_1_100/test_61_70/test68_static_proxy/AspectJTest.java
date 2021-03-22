package com.spring_1_100.test_61_70.test68_static_proxy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectJTest {

    @Pointcut("execution(* com.spring_1_100.test_61_70.test68_static_proxy.*.*(..))")
    public void test() {

    }


    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint p) {
        System.out.println("around before1");
        Object o = null;
        try {
            o = p.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around after1");
        return o;
    }


}
