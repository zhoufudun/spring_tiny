package com.spring_101_200.test_111_120.test_117_excution.excution11;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {

    //11.任何持有@java.lang.Deprecated和@cn.javass..Secure注解的方法
    //@Before("execution(@java.lang.Deprecated @com.spring_101_200..MyAnnotation * *(..))")
    @Before("execution(@(java.lang.Deprecated || com.spring_101_200..MyAnnotation) * *(..))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }


}
