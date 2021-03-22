package com.spring_101_200.test_121_130.test_125_mybatis_properties;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    void insertUser(User user);

    User getUser(Long id);

    List<User> getUserList(@Param("id") long id);

    @MapKey("username")
    Map getUserByMap(@Param("id") long id);

    void getUserByResultHandler(@Param("id") long id, ResultHandler resultHandler);


    @ResultType(User.class)
    User getUserByUser(User user);


    UserBill selectUserBill(Long id );


    UserInfo findUserById(Long id );

    UserInfo findUserCompexById(Long id );

    UserBill findUserBillLazyLoading(Long id );


   UserBill selectBillInfo(@Param("billId") Long billId, @Param("userId") Long userId );

    void updateById(User user);
}
