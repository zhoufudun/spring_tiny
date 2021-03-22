package com.spring_1_100.test_1_10.test10_application_bean_life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition bd = beanFactory.getBeanDefinition("car");
        bd.getPropertyValues().addPropertyValue("brand","奇瑞 QQ");
        System.out.println("调用 BeanFactoryPostProcessor.postProcessBeasnFactory()");
    }
}
