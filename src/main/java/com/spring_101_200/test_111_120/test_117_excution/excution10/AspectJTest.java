package com.spring_101_200.test_111_120.test_117_excution.excution10;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {



    //10.任何持有@java.lang.Deprecated注解的方法
    @Before("execution(@java.lang.Deprecated * *(..))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
