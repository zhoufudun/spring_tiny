package com.spring_101_200.test_111_120.test_117_excution.excution14;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {

    //14 表示被调用的类上必需有MyAnnotation 注解
    @Before("execution(* (@com.spring_1_100..MyAnnotation *).*(..))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }


}
