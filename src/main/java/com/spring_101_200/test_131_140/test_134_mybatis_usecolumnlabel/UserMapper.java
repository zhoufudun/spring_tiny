package com.spring_101_200.test_131_140.test_134_mybatis_usecolumnlabel;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User findUserById(@Param("id") Long id);

}
