package com.spring_1_100.test_1_10.test;

import com.spring_1_100.test_1_10.test3.InstrumentTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest14 {


    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext classPathXmlApplicationContext
                = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_11_20/spring14.xml");



        InstrumentTest instrumentTest = (InstrumentTest) classPathXmlApplicationContext.getBean("instrumentTest");
        System.out.println(instrumentTest.getInstrument());




    }
}
