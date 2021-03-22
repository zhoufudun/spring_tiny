package com.spring_1_100.test_81_90.test88_advisor;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {
    private static List<String> specialClientList = new ArrayList<>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
    }

    public boolean matches(Method method, Class<?> targetClass) {
        System.out.println("调用matches(method,clazz)" + targetClass.getName() + "." + method.getName() + " 做静态检查");
        return "greetTo".equals(method.getName());
    }

    //      对类进行静态切点检查
    // 切点类匹配规则：为Waiter的类或子类
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> clazz) {
                System.out.println("调用getClassFilter()对" + clazz.getName() + " 做静态检查.");
                return Waiter.class.isAssignableFrom(clazz);
            }
        };
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object[] args) {
        System.out.println("调用matches(method,clazz)" + targetClass.getName() + "." + method.getName() + " 做动态检查");
        String clientName = (String)args[0];
        return specialClientList.contains(clientName);
    }

}
