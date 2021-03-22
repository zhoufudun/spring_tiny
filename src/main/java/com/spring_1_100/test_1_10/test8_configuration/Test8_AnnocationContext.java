package com.spring_1_100.test_1_10.test8_configuration;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 在获取 ApplicationContext 实例后，就可以像 BeanFactory 一样调用 getBean(beanName)  返回一个 bean了
 * ApplicationContext 的初始化和 BeanFactory 有了一个重大的区别：BeanFactory 在初始化容器的时，并未实例化
 * 和 Bean，直到第一次访问某个
 *
 * 通过 HierarchicalBeanFactory 接口，Spring 的 IOC 容器可以建立父子层级关联的容器体系，子容器可以访问父容器中的 bean , 但是父容器
 * 不能访问子容器的 bean , 在容器内 bean 的 id 必须是唯一的，但是子容器可以拥有一个和父容器 id 相同的 bean ，父子容器层级体系增强了
 * Spring  容器架构的扩展性和灵活性，因为第三方可以通过编程的方式，为一个己经存在的容器添加一个或者多个特用途的子容器，以提供一些额外的
 * 功能
 * Spring 使用了父子容器实现了很多的功能，比如在 Spring MVC  中展现层 Bean 位于一个子容器中，而业务层和持久层的 bean 位于欠容器中
 * 这样，展现层的 bean 就可以引用业务层和持久层的 bean ， 而业务层和持久层的 bean 则看不到展现层的 bean
 *
 */
public class Test8_AnnocationContext {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
        Car car = ctx.getBean("car", Car.class);
        System.out.println(JSON.toJSONString(car));
    }

}
