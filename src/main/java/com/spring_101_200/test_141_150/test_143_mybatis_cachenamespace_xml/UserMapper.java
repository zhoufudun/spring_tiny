package com.spring_101_200.test_141_150.test_143_mybatis_cachenamespace_xml;


import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUser(@Param("id") Long id);
}
