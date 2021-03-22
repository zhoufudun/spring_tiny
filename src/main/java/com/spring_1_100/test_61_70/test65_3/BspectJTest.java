package com.spring_1_100.test_61_70.test65_3;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class BspectJTest {

    @Pointcut("execution(* com.spring_1_100.test_61_70.test65_3.*.*(..)) && args(..)")
    public void test() {

    }


    @Before("test()")
    public void bbbbbbbbbbbbbb(JoinPoint jp) {
        System.out.println("bbbbbbbbbbbbbb" + JSON.toJSONString(jp.getArgs()));
    }


}
