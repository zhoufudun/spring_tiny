package com.spring_1_100.test_41_50.test41;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ClassUtils;
import org.springframework.util.MethodInvoker;

import java.lang.reflect.Constructor;

public class Test41 {



    @Test
    public void test2(){
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_41_50/spring41.xml");
        System.out.println(JSON.toJSONString(bf.getBean("user")));
    }

    @Test
    public void test3(){
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_41_50/spring41_1.xml");
        System.out.println(JSON.toJSONString(bf.getBean("person")));
    }


    @Test
    public void testxx(){
        User user = new User();
        Class clazz = user.getClass();
        Constructor<?> [] constructors = clazz.getDeclaredConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor);
        }
    }
}

