package com.spring_101_200.test_111_120.test_117_excution.excution17;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {

    //17.任何带有两个参数的方法，且这两个参数都被@com.spring_1_100..MyAnnotation标记了；且这两个参数的类型上都持有@com.spring_1_100..MyAnnotation
    @Before("execution(* *(@com..MyAnnotation (@com..MyService *),@com..MyAnnotation (@com..MyService  *)))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }


}
