package com.spring_1_100.test_61_70.test64_2;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {


    void login(String userName);

    void getUserName();

    void testBirth(Date date);

    void testObject(Object object);


    void testException(Date date) throws Exception;

    void testIllegalArgumentException() throws IllegalArgumentException;

    void testDeprecated() throws IllegalArgumentException;


    void testDeprecatedMyAnnotation();

    User getUser();

    int getAge();

    void getParentName();

    void getUser(String userName, String password);

    void getUser(String userName);

    int getAge(String username, String password);


    void getUserInfo(User user);


    void getUserHomeWork(User zhangsan, User lizi);

    void getUserHomeInfo(User zhangsan, User lisi);

    void testModel(Map<Model, Model> modelMap, String a);

    void testModel1(String a, Map<Model, Model> modelMap);

    void testModel2(Map modelMap, String a);

    void testMyUser(List<User> users);

    void testMyCollection(Collection<User> users);

    void testMyModel(List<Model> models);

    void testArgs1(Model model);
    void testArgs2(Model model,String a );
}
