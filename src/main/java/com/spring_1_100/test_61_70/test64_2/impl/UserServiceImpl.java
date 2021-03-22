package com.spring_1_100.test_61_70.test64_2.impl;

import com.spring_1_100.test_61_70.test64_2.Model;
import com.spring_1_100.test_61_70.test64_2.MyAnnotation;
import com.spring_1_100.test_61_70.test64_2.User;
import com.spring_1_100.test_61_70.test64_2.UserService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService, Serializable {
    @Override
    public void login(String userName) {
        System.out.println(userName + " 登陆");
    }


    @Override
    public void getUserName() {
        System.out.println("我是张三");
    }

    @Override
    public void testBirth(Date date) {
        System.out.println(" testBirth :" + date);
    }

    @Override
    public void testObject(Object object) {
        System.out.println(" object :" + object);
    }

    @Override
    public void testException(Date date) throws Exception {
        System.out.println("testException " + date);
    }

    @Override
    public void testIllegalArgumentException() throws IllegalArgumentException {
        System.out.println("testIllegalArgumentException ");
    }


    @Override
    @Deprecated
    public void testDeprecated() throws IllegalArgumentException {
        System.out.println("testDeprecated ");
    }


    @Override
    @Deprecated
    @MyAnnotation
    public void testDeprecatedMyAnnotation() {
        System.out.println("testDeprecatedMyAnnotation ");
    }

    @Override
    public User getUser() {
        System.out.println("getUser");
        return null;
    }

    @Override
    public int getAge() {
        System.out.println("getAge");
        return 0;
    }

    @Override
    public @MyAnnotation
    void getParentName() {
        System.out.println("getParentName");
    }

    @Override
    public void getUser(@MyAnnotation String userName, @MyAnnotation String password) {
        System.out.println("userName :" + userName + ",password :" + password);
    }

    @Override
    public int getAge(String userName, @MyAnnotation String password) {
        System.out.println("userName :" + userName + ", age = " + 10);
        return 1;
    }

    @Override
    public void getUserInfo(User user) {
        System.out.println("getUserInfo :");
    }


    @Override
    public void getUser(String userName) {
        System.out.println("userName :" + userName);
    }


    @Override
    public void getUserHomeWork(@MyAnnotation User zhangsan, @MyAnnotation User lizi) {
        System.out.println("getUserHomeWork zhangsan lisi:");
    }

    @Override
    public void getUserHomeInfo(@MyAnnotation User zhangsan, User lizi) {
        System.out.println("getUserHomeInfo wangwu zhaoliu");
    }

    @Override
    public void testModel(Map<Model, Model> modelMap, String a) {
        System.out.println("testModel");
    }

    @Override
    public void testModel1(String a, Map<Model, Model> modelMap) {
        System.out.println("testModel1");
    }

    @Override
    public void testModel2(Map modelMap, String a) {
        System.out.println("testModel2");
    }

    @Override
    public void testMyUser(List<User> users) {
        System.out.println("testMyUser");
    }

    @Override
    public void testMyModel(List<Model> models) {
        System.out.println("testMyModel");
    }

    @Override
    public void testArgs1(Model model) {
        System.out.println("testArgs1");
    }

    @Override
    public void testArgs2(Model model, String a) {
        System.out.println("testArgs2");
    }

    @Override
    public void testMyCollection(Collection<User> users) {
        System.out.println("testMyCollection");
    }


}
