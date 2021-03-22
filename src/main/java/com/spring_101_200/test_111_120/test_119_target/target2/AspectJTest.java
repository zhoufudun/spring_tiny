package com.spring_101_200.test_111_120.test_119_target.target2;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {


    //2.任何目标对象持有 MyAnnotation 注解的类方法；必须是在目标对象上声明这个注解，在接口上声明的对它不起作用
    @Before("@target(com.spring_101_200.test_111_120.test_119_target.target2.MyAnnotation)")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
