package com.spring_1_100.test_61_70.test65_0;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

    @Pointcut("execution(* com.spring_1_100.test_61_70.test65_0.*.*(..)) && args(..)")
    public void test() {

    }


    @After("test()")
    public void afterTest() {

        System.out.println(" after xxxxxxxxxxxxxxx()");
    }

    @AfterThrowing(pointcut = "test()", throwing = "e")
    public void afterThrowing(Exception e) {
        System.out.println("例外通知");
        System.out.println(e.getMessage());
    }



    @Around("test()")
    public Object doAround(ProceedingJoinPoint p) throws Throwable {
        System.out.println("around before1");
        Object o = null;
        o = p.proceed();
        System.out.println("around after1");
        return o;
    }


}
