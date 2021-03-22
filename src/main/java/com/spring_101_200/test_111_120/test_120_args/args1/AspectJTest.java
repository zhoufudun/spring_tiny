package com.spring_101_200.test_111_120.test_120_args.args1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {


    @Before("args(java.io.Serializable,..)")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
