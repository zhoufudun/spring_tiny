package com.spring_101_200.test_131_140.test_132_mybatis_typehandlers;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    void insertUser(User user);

   User getUser(Long id);

    User getUserByMap(@Param("id") long id);
}
