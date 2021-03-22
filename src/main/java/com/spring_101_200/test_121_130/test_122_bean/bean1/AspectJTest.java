package com.spring_101_200.test_121_130.test_122_bean.bean1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectJTest {


    // f) bean
    // 1.匹配所有以Service命名（id或name）结尾的Bean
    @Before(value="bean(*Service)")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

}
