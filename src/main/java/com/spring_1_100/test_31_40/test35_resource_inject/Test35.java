package com.spring_1_100.test_31_40.test35_resource_inject;


import com.alibaba.fastjson.JSON;
import com.spring_1_100.test_31_40.test35_resource_inject.anno.Dog;
import com.spring_1_100.test_31_40.test35_resource_inject.anno.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.LinkedList;
import java.util.List;

public class Test35 {
    // 这时，如果@Resource未指定"car"属性，则也可以根据属性方法得到需要注入的Bean的名称，可见@Autowired 默认按类型
    // 匹配注入Bean 的，只不过它没有required属性，可见不管是@resource还是@Inject注解，其功能都没有
    // @Autowired丰富，因此除非必要在可以不必在乎这两个属性
    @Test
    public void test() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring35_resource_inject.xml");
        Boss boss = (Boss) ac.getBean("boss");
        System.out.println(boss.getCar());
    }


    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring_1_100/config_31_40/spring35_resource_inject_1.xml");
        User user = (User) ac.getBean("xxxx");
        Dog d = (Dog) ac.getBean("d");
        System.out.println(d);
        user.drive();
    }


    @Test
    public void test2(){
        String annotationType= "11";
        MultiValueMap<String, AnnotationAttributes> attributesMap = new LinkedMultiValueMap<String, AnnotationAttributes>(4);
        List<AnnotationAttributes> attributes = attributesMap.get(annotationType);
        AnnotationAttributes annotationAttributes  = new AnnotationAttributes();
        if (attributes == null) {
            System.out.println("-----------bbbbbbbbbbbbbbbbbbbbb");
            attributesMap.add(annotationType, annotationAttributes);
        }
        else {
            attributes.add(0, annotationAttributes);
        }
        attributes = attributesMap.get(annotationType);
        if(attributes instanceof LinkedList){
            System.out.println("==================");
        }

    }
}


