package com.spring_1_100.test_11_20.test17_parent_child_constains;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test17 {

    public static void main(String[] args) {

        ApplicationContext parentParentParent = new ClassPathXmlApplicationContext(
                "classpath:spring_1_100/config_11_20/test17_parent_child_constains/spring17_parent_parent_parent.xml");


        ApplicationContext parentParent = new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring_1_100/config_11_20/test17_parent_child_constains/spring17_parent_parent.xml"},
                parentParentParent
        );

        ApplicationContext parent = new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring_1_100/config_11_20/test17_parent_child_constains/spring17_parent.xml"},
                parentParent
        );

        ApplicationContext child = new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring_1_100/config_11_20/test17_parent_child_constains/spring17_child.xml"},
                parent
        );

        Boss boss1 = (Boss) child.getBean("boss1");
        System.out.println(JSON.toJSONString(boss1.getCar()));
        Boss boss2 = (Boss) child.getBean("boss2");
        System.out.println(JSON.toJSONString(boss2.getCar()));

        Boss boss3 = (Boss) child.getBean("boss3");
        System.out.println(JSON.toJSONString(boss3.getCar()));


        Boss boss4 = (Boss) child.getBean("boss4");
        System.out.println(JSON.toJSONString(boss4.getCar()));



        Boss boss5 = (Boss) child.getBean("boss5");
        System.out.println(JSON.toJSONString(boss5.getCar()));


        Boss boss6 = (Boss) child.getBean("boss6");
        System.out.println(JSON.toJSONString(boss6.getCar()));
    }
}
