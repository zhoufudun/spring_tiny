package com.spring_1_100.test_61_70.test65_2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AspectJTest {

    @Pointcut("execution(* com.spring_1_100.test_61_70.test65_2.*.*(..)) && args(x,y)")
    public void test(String x,String y) {

    }

    @Before("test(x,y)")
    public void abeforeTest(String x, String y) {
        System.out.println("abeforeTest x: " + x  + " y : " + y);
    }


    @Before("test(x,y)")
    public void beforeTest(String x,String y ) {
        System.out.println("beforeTest");
    }


    @After("test(x,y)")
    public void afterTest(String x,String y) {
        System.out.println("afterTest()");
    }


    @After("test(x,y)")
    public void bafterTest(String x,String y) {
        System.out.println("bafterTest()");
    }


    @AfterReturning(value = "test(x,y)",returning = "returnValue")
    public void AfterReturning(String x,String y ,String returnValue) {
        System.out.println("AfterReturning()" + returnValue);
    }


    @AfterThrowing(pointcut = "test(x,y)", throwing = "e")
    public void afterThrowing(String x,String y ,Exception e) {
        System.out.println("例外通知");
        System.out.println(e.getMessage());
    }



    @Around("test(x,y)")
    public Object aroundTest(ProceedingJoinPoint p,String x,String y) {
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
