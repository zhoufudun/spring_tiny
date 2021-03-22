package com.spring_101_200.test_111_120.test_117_excution.excution16;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {

    @Before("execution(* *(@com..MyAnnotation *))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }


}
