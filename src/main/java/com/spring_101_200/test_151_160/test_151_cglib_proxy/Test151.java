package com.spring_101_200.test_151_160.test_151_cglib_proxy;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.*;

public class Test151 {

    public static void main(String[] args) {
        HelloServiceCglib cglibProxy = new HelloServiceCglib();
        HelloService helloService = (HelloService) cglibProxy.getInstance(new HelloServiceImpl());
        helloService.sayHello("张三");

        System.out.println(Map.class.isAssignableFrom(HashMap.class));

        System.out.println("HashMap:" + Collection.class.isAssignableFrom( HashMap.class));
        System.out.println(Collection.class.isAssignableFrom(Collection.class));
        System.out.println(Collection.class.isAssignableFrom(List.class));
        System.out.println(Collection.class.isAssignableFrom(HashSet.class));
        System.out.println(Collection.class.isAssignableFrom(ArrayList.class));
    }


}





