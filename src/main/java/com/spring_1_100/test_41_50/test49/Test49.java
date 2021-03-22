package com.spring_1_100.test_41_50.test49;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test49 {


    public static void main(String[] args) {
        ApplicationContext bf = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_41_50/spring49.xml");
        Student student = bf.getBean(Student.class);
        Teacher teacher = bf.getBean(Teacher.class);
        System.out.println(student);
        System.out.println(teacher.getUserName());

    }


}
