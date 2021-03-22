package com.spring_1_100.test_1_10.test10_application_bean_life;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {


    // 接口方法，在实例化 bean 的前进行调用
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        // 仅对容器中的 car Bean 进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAwarebeanPostProcessor.postProcessBeforeInstantiation ");
        }
        return null;
    }


    // 接口方法，在实例化 Bean 后调用
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        // 仅对容器中的 car Bean 进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation ");
        }
        return true ;
    }

    // 接口方法，在设置某个属性时调用
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        // 仅对容器中的 car Bean 进行处理，还可以通过 pdst 入参进行过虑
        // 仅对car 的某个特定的属性进行处理
        if("car".equals(beanName)){
            System.out.println("InstantiationAwareBeanPostProcessor.postProcessPropertyValues ");
        }
        return pvs;
    }




}
