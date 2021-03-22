package com.spring_1_100.test_61_70.test62;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.ResolvableType;

public class Test62 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring62.xml");

        TestEvent event = new TestEvent("hello", "msgxxxxxx");
        ac.publishEvent(event);

    }

    interface Service<N, M> {

    }


    interface ServiceImpl<N, M> extends Service<N, M> {

    }


    interface ServiceImplImpl extends ServiceImpl<String, Integer> {

    }


    @Test
    public void test() {
        ResolvableType impl = ResolvableType.forClass(ServiceImplImpl.class);
        ResolvableType service = ResolvableType.forClass(Service.class);


        boolean a = service.isAssignableFrom(impl);
        System.out.println(a);
    }

}





