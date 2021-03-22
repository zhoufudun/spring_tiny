package com.spring_101_200.test_111_120.test_117_excution.excution1;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {


    @Before("execution(* com.spring_101_200.test_111_120.test_117_excution.excution1.*.*(..))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
