package com.spring_101_200.test_131_140.test_140_mybatis_select;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    @Select("select * from lz_user where id=#{id} or username=#{username}")
    User getUserInfo(@Param("id") Long id, @Param("username") String username);

    @ResultType(User.class)
    User getUser(@Param("id") long id);


}
