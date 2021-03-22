package com.spring_1_100.test_31_40.test34_list_inject;


import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonGenerator;
import com.spring_1_100.test_31_40.test33_component_scan.LogonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.security.util.AuthResources_it;

public class Test34 {
    // Spring 如果发现变量是一个集合类，则它会将容器中匹配集合元素的类型所有的Bean 都注入进来，这里
    // Plugin 为一个接口，它拥有两个实现类，分别是OnePlugin ,TwoPlugin ，这两个实现类都通过
    // @Component 标注为Bean ，则Spring会将这两个Bean都注入plugins 中
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring34_list_inject.xml");
        MyComponent myComponent= (MyComponent)ac.getBean("myComponent");

        System.out.println(JSON.toJSONString(myComponent.getPluginsList()));

    }
}


