package com.spring_101_200.test_131_140.test_135_mybatis_executor;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    User findUserById(@Param("id") Long id);

    int update(@Param("id") long id);

    void updateRealName(@Param("id") long id, @Param("realName") String realName,int a );

}
