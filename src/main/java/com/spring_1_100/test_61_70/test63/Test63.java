package com.spring_1_100.test_61_70.test63;

import org.springframework.core.convert.support.DefaultConversionService;

public class Test63 {

    public static void main(String[] args) {
        //  ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_61_70/spring63.xml");

        DefaultConversionService conversionService = new DefaultConversionService();




        String phoneNumber = "010-12349832xxxxx98";

        PhomeNumerModel model = conversionService.convert(phoneNumber, PhomeNumerModel.class);


        System.out.println("++++++++++" + model.getAreaCode());
    }








}