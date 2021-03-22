package com.spring_1_100.test_71_80.test72_mybatis_scan;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test72 {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("spring_1_100/config_71_80/spring72/spring72.xml");

        UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
        User user = userMapper.getUser(456l);
        System.out.println(JSON.toJSONString(user));

        HelloMessage helloMessage = ac.getBean(HelloMessage.class);
        System.out.println(helloMessage.getMsg());

    }

}
