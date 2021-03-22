package com.spring_1_100.test_91_100.test97_ltw_2;

import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class PreGreetingAspect {
    public PreGreetingAspect() {
    }

    @Before("execution(* com.spring_1_100.test_91_100.test97_ltw.*.*(..))")
    public void beforeTest() {
        System.out.println("beforeTest");
    }
/*
    public static PreGreetingAspect aspectOf() {
        if (ajc$perSingletonInstance == null) {
            throw new NoAspectBoundException("com.spring_1_100.test_91_100.test97_ltw.PreGreetingAspect", ajc$initFailureCause);
        } else {
            return ajc$perSingletonInstance;
        }
    }

    public static boolean hasAspect() {
        return ajc$perSingletonInstance != null;
    }

    static {
        try {
            ajc$postClinit();
        } catch (Throwable var1) {
            ajc$initFailureCause = var1;
        }

    }*/
}
