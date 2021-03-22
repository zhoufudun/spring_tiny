package com.spring_1_100.test_31_40.test32_factory_bean;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test32 {

    /**
     * Bean 的定义信息
     * Bean 实现类
     * Spring  本身
     *  如果采用基于 XML 的配置，Bean 的定义信息和 Bean 的实现类本身是分离的，而采用基于注解的配置文件时。
     *  Bean 的定义信息即通过 Bean 实现类上的标注注解实现。
     *
     */
    public static void main(String[] args) throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring32_factory_bean.xml");
        Car car = (Car) ac.getBean("car");
        System.out.println(JSON.toJSONString(car));
        CarFactoryBean carFactoryBean = (CarFactoryBean) ac.getBean("&car");
        Car car1 = carFactoryBean.getObject();
        System.out.println(car == car1);
    }
}
