package com.spring_101_200.test_111_120.test_120_args.args2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {


    @Before("@args(com.spring_101_200.test_111_120.test_120_args.args2.MyAnnotation,..)")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
