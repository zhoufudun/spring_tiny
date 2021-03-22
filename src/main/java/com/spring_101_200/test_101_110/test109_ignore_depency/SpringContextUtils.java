package com.spring_101_200.test_101_110.test109_ignore_depency;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtils implements ApplicationContextAware {

    @Autowired
    public  ApplicationContext applicationContext;

    @Autowired
    private UserService userService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("======"+applicationContext);
       // this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        System.out.println("userService:"+userService);
        return applicationContext;

    }
}
