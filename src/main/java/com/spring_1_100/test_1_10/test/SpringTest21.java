package com.spring_1_100.test_1_10.test;

import com.spring_1_100.test_1_10.test2.cn21.HePerson;
import com.spring_1_100.test_1_10.test2.cn21.MyPerson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Slf4j
// todo 没有解决正确
public class SpringTest21 {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_21_30/spring21_map_attr.xml");

        MyPerson myPerson = classPathXmlApplicationContext.getBean(MyPerson.class);
        System.out.println(" myPerson :" + myPerson);
        System.out.println(" myPerson.getPerson() :" + myPerson.getPerson());
        myPerson.getPerson().hair();


        HePerson person = classPathXmlApplicationContext.getBean(HePerson.class);
        System.out.println("==============="+person);

    }
}
