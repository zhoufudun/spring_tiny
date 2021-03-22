package com.spring_1_100.test_1_10.test9_bean_life_cycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {


    public static void test(){
        // 下面两句装载配置文件并启动容器

        Resource resource = new ClassPathResource("spring_1_100/config_1_10/spring9_life_cycle.xml");
        BeanFactory bf = new XmlBeanFactory(resource);

        //  向容器中注册 MyBeanPostProcessor 后处理器
         ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory)bf).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());
        // 第一次从容器中获取 car，将触发容器实例化该 Bean ，这将引发 Bean 循环依赖周期方法的调用
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        // 第二次从容器中获取 Car ，直接从缓存池中获取
        Car car2 = (Car) bf.getBean("car");
        // 查看 car1 和 car2 是否指向同一个引用
        System.out.println("car1==car2:" + (car1 == car2));
        ((XmlBeanFactory)bf).destroySingletons();
    }

    public static void main(String[] args) throws Exception {
       test();
    }
}
