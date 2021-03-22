package com.spring_101_200.test_121_130.test_121_this.this1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {


    // c) this
    //1.当前AOP对象实现了 UserService 接口的任何方法
    @Before("this(com.spring_101_200.test_121_130.test_121_this.this1.UserService)")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
