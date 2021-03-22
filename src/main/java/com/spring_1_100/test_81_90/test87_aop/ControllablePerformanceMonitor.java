package com.spring_1_100.test_81_90.test87_aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ControllablePerformanceMonitor extends DelegatingIntroductionInterceptor implements Monitorable {
    private ThreadLocal<Boolean> monitorStatusMap = new ThreadLocal<>();

    @Override
    public void setMonitorAdcive(boolean active) {
        monitorStatusMap.set(active);
    }
    // 用于保存性能监视开关状态，之所以需要使用ThreadLoacal变量，是因为这个控制状态使代理类变成也非线程安全的实例，为了解决单例线程安全
    // 通过ThreadLocal让每个线程单独使用一个状态。
    // 拦截器方法
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object obj = null;
        // 对于支持性能监视可控代理，通过判断其状态决定是否开户性能监控功能。
        if (monitorStatusMap.get() != null && monitorStatusMap.get()) {
            long startTime = System.currentTimeMillis();
            Thread.sleep(2000);
            obj = super.invoke(mi);
            long end = System.currentTimeMillis();
            System.out.println("执行时间：" + (end - startTime));
        } else {
            obj = super.invoke(mi);
        }
        return obj;
    }
}
