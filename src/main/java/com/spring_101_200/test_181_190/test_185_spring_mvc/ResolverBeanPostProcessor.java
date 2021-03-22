package com.spring_101_200.test_181_190.test_185_spring_mvc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ResolverBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("============================"+beanName);
        if ("org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter#0".equals(beanName)) {
            //requestMappingHandlerAdapter进行修改
            RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;
            List<HandlerMethodArgumentResolver> argumentResolvers = adapter.getArgumentResolvers();
            //添加自定义参数处理器
            List<HandlerMethodArgumentResolver> argumentResolverList = new ArrayList<>();
            argumentResolverList.add(new MultiRequestBodyArgumentResolver());
            argumentResolverList.addAll(argumentResolvers);
            adapter.setArgumentResolvers(argumentResolverList);
        }
        return bean;
    }

}