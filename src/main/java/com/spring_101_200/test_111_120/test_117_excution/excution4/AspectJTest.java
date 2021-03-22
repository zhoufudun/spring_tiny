package com.spring_101_200.test_111_120.test_117_excution.excution4;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {


    @Before("execution(* com.spring_101_200..*.*(..))")                                    //com.spring_1_100 包及所有子包下任何类的任何方法
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
