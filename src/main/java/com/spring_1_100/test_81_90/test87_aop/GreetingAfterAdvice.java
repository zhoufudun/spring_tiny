package com.spring_1_100.test_81_90.test87_aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingAfterAdvice implements AfterReturningAdvice {

    /**
     *
     * @param returnValue 为目标实例方法返回的结果
     * @param method  为目标类方法
     * @param args   目标实例的方法的入参
     * @param target    为目标类实例
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("please enjoy youself !");
    }
}
