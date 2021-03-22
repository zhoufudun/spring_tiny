package com.spring_1_100.test_31_40.test33_component_scan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LogonService {
    // @Autowired 默认按类型匹配的方式，在容器查找匹配的Bean ,当有且仅有一个匹配的Bean时，Spring
    // 将其注入到@Autowired标注的变量中
    // 如果容器中没有一个标变量类型匹配的Bean，Spring 容器启动时将报NoSuchBeanDefinitionException 的异常，如果希望
    // Spring 即使找不到匹配的Bean完成注入也不要抛出异常，那么可以使用@Autowired(required=false)进行标注
    // 默认的情况下，@Autowired的requested 的属性值为true ，即要求一定要找到匹配的Bean
    @Autowired
    private LogDao logDao;

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;


    // 如果一个方法拥有多个入参，在默认的情况下，Spring 自动选择匹配的入参类型的bean ，进行注入，Spring 允许对方法的
    // 入参标注，@Qualifier以指定注入的Bean的名称，如下所示
    @Autowired
    private void init(@Qualifier("otherUserDao") OtherUserDao otherUserDao ,LogDao logDao){

    }
}
