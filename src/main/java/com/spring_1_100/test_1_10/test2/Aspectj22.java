package com.spring_1_100.test_1_10.test2;


import com.utils.LogUtils;
import org.aspectj.lang.ProceedingJoinPoint;

public class Aspectj22 {


    //@Pointcut("execution(public * com.spring1_100.test_1_10.test2..*.*(..))")
    public void webLog() {

    }


    public Object doAround(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            LogUtils.info("111111111111111111111111111111111");
            result = pjp.proceed();
            LogUtils.info("22222222222222222222222222222222");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }


}
