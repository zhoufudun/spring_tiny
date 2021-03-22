package com.spring_101_200.test_101_110.test109_ignore_depency;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test109 {


    // 自动装配时忽略给定的依赖接口，典型的应用是通过其他的方式解析Application上下文注册依赖，类似于 BeanFactory 通过 BeanFactoryWare
    // 进行注入或者 ApplicationContext 通过 ApplicationContextAware 进行注入
    @Test
    public void test() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        UserController userController = ac.getBean(UserController.class);
        userController.test();

    }

}
