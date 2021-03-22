package com.spring_1_100.test_1_10.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test3<T> {


    public static void main(String[] args) {
        Person person = new Person();
        person.setA("a1");
        person.setB("b1");
        String a = JSON.toJSONString(person);
        System.out.println(a );
        Person p = test(a,Person.class);
        System.out.println("============" + JSON.toJSONString(p));

    }

    public static <T> T test(String text, Class<T> clazz) {
        T t = JSONObject.parseObject(text, clazz);
        return t;
    }
}
