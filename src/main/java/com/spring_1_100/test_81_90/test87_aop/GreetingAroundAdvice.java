package com.spring_1_100.test_81_90.test87_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class GreetingAroundAdvice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object [] args = invocation.getArguments();//目标方法入参
        String clientName = (String)args[0];
        System.out.println("How are you ============ ! Mr. around  " + clientName + " . ");
        Object obj = invocation.proceed();
        System.out.println(" Please enjoy ================ yourself ! ");
        return obj;
    }
}
