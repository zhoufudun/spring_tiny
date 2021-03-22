package com.spring_1_100.test_1_10.test10_application_bean_life;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {


    public static void test() {
        // 下面两句装载配置文件并启动容器

        ApplicationContext bf = new ClassPathXmlApplicationContext("spring_1_100/config_1_10/spring10_bean_life_cycle.xml");

        // 第一次从容器中获取 car，将触发容器实例化该 Bean ，这将引发 Bean 循环依赖周期方法的调用
        Car car1 = (Car) bf.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        // 第二次从容器中获取 Car ，直接从缓存池中获取
        Car car2 = (Car) bf.getBean("car");
        // 查看 car1 和 car2 是否指向同一个引用
        System.out.println("car1==car2:" + (car1 == car2));
    }

    public static void main(String[] args) throws Exception {
        test();
    }
}
