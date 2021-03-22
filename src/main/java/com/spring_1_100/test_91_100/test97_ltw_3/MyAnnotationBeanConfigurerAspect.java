package com.spring_1_100.test_91_100.test97_ltw_3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.AnnotationBeanWiringInfoResolver;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.aspectj.AbstractInterfaceDrivenDependencyInjectionAspect;
import org.springframework.beans.factory.aspectj.ConfigurableObject;
import org.springframework.beans.factory.wiring.BeanConfigurerSupport;


public class MyAnnotationBeanConfigurerAspect extends AbstractInterfaceDrivenDependencyInjectionAspect
        implements BeanFactoryAware, InitializingBean, DisposableBean {

    private BeanConfigurerSupport beanConfigurerSupport = new BeanConfigurerSupport();


    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanConfigurerSupport.setBeanWiringInfoResolver(new AnnotationBeanWiringInfoResolver());
        this.beanConfigurerSupport.setBeanFactory(beanFactory);
    }

    public void afterPropertiesSet() {
        this.beanConfigurerSupport.afterPropertiesSet();
    }

    public void configureBean(Object bean) {
        this.beanConfigurerSupport.configureBean(bean);
    }

    public void destroy() {
        this.beanConfigurerSupport.destroy();
    }

}

