package com.spring_1_100.test_1_10.test7_xml_beanfactory;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class Test7_XmlBeanFactory {
    // ApplicationEventPublisher : 让容器拥有发布应用的上下文事件的功能，包括容器的启动事件，关闭事件等，实现了 ApplicationListener
    // 事件监听接口的 Bean 可以接收到容器事件，并对事件进行响应处理，在 ApplicationContext 抽象实现类 AbstractApplicationContext
    // 中，我们可以发现存在一个 ApplicationEventMulticaster ，
    // 它负责保存所有的监听器，以便在容器产生上下文事件通知这些事件监听器
    // MessageSource :
    public static void main(String[] args) {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:spring_1_100/config_1_10/spring7_xml_beanfactory.xml");
        BeanFactory bf = new XmlBeanFactory(res);
        System.out.println(" init beanFactory");

        Car car = bf.getBean("car", Car.class);
        System.out.println(JSON.toJSONString(car));

    }
}
