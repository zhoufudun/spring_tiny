package com.spring_1_100.test_51_60.test53;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class TestBeanFactory implements BeanFactoryAware {

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }





    public void testAware(){
        Hello hello = (Hello) beanFactory.getBean("hello");
        hello.say();
    }


}
