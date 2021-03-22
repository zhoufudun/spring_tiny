package com.spring_101_200.test_111_120.test_117_excution.excution21;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {

    //13. 任何返回值类型持有@cn.javass..Secure的方法
    @Before("execution(* @com.spring_101_200.test_111_120.test_117_excution.excution21.MyAnnotation(value=1,age=1)  *.*(..))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }


}
