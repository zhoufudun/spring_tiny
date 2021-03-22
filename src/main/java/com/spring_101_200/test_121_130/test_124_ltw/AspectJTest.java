package com.spring_101_200.test_121_130.test_124_ltw;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJTest {


    @Before("execution(* com.spring_101_200.test_121_130.test_124_ltw.*.*(..)))")
    public void beforeTest() {
        System.out.println("beforeTest ");
    }


}
