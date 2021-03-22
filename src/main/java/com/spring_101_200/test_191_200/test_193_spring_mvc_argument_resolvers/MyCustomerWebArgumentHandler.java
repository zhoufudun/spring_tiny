package com.spring_101_200.test_191_200.test_193_spring_mvc_argument_resolvers;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class MyCustomerWebArgumentHandler implements WebArgumentResolver {
    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        if (methodParameter.getParameterType().equals(User.class)) {
            System.out.println("================参数设置=============");
            User argu = new User();
            argu.setUsername("winzip");
            argu.setPassword("123456");
            return argu;
        }
        return UNRESOLVED;
    }
}