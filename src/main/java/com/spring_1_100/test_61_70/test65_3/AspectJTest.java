package com.spring_1_100.test_61_70.test65_3;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.Order;

@Aspect
public class AspectJTest implements PriorityOrdered{

    @Pointcut("execution(* com.spring_1_100.test_61_70.test65_3.*.*(..)) && args(..)")
    public void test() {

    }


    @Before("test()")
    public void aaaaaaaaaaaa(JoinPoint jp) {
        System.out.println("aaaaaaaaaaaa" + JSON.toJSONString(jp.getArgs()));
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
