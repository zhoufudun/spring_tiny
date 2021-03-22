package com.spring_101_200.test_111_120.test_117_excution.excution18;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {

    //@Before("execution(* *(java.util.Map<com..Model, com..Model>, ..))")
    //@Before("execution(* *(java.util.Map [][]<com..Model, com..Model>+[][]..., ..))")
    @Before("execution(* *(java.util.Map<com..Model, com..Model>, ..))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
