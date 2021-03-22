package com.spring_1_100.test_81_90.test88_advisor;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class GreetingComposablePointcut {

    public Pointcut getIntersectionPointcut() {
        // 创建一个复合切点
        ComposablePointcut cp = new ComposablePointcut();
        // 创建一个流程切点
        Pointcut p1 = new ControlFlowPointcut(WaiterDelegate.class, "service");
        // 创建一个方法名切点
        NameMatchMethodPointcut pt2 = new NameMatchMethodPointcut();
        pt2.addMethodName("greetTo");
        return cp.intersection(p1).intersection((Pointcut) pt2);

    }
}
