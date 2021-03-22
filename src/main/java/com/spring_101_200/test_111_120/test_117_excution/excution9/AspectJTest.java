package com.spring_101_200.test_111_120.test_117_excution.excution9;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {

    //9. 任何实现了com.spring_1_100 包及所有子包下 UserService 接口和java.io.Serializable接口的类型的任何方法
    @Before("execution(* (com..User*+ && java.io.Serializable+).*(..))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }



}
