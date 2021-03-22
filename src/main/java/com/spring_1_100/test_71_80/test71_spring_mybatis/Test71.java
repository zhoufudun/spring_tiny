package com.spring_1_100.test_71_80.test71_spring_mybatis;

import com.alibaba.fastjson.JSON;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test71 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_71_80/spring71_mybatis_origin/spring71.xml");
        UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
        User user = userMapper.getUser(456l);
        System.out.println(JSON.toJSONString(user));
    }

}
