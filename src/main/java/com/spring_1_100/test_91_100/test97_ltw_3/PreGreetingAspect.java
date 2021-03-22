package com.spring_1_100.test_91_100.test97_ltw_3;

import com.sun.tracing.dtrace.ArgsAttributes;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class PreGreetingAspect {


    @Pointcut("execution(* com.spring_1_100.test_91_100.test97_ltw.*.*(..))  && args(..)")
    public void test() {
        System.out.println("beforeTest");
    }


    @Before("test()")
    public void beforeTest() {
        System.out.println("beforeTest");
    }



    @After("test()")
    public void after() {
        System.out.println("after");
    }



    @AfterThrowing(value = "test()",throwing = "e")
    public void afterThrowing(Exception e ) {
        System.out.println("afterThrowing");
    }


    @AfterReturning(value = "test()",returning = "b")
    public void afterReturning(String     b ) {
        System.out.println("afterReturning b :" + b );
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
