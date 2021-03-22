package com.spring_101_200.test_141_150.test_144_mybatis_cachenamespaceref;

import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@CacheNamespaceRef(UserMapper.class)
public interface UserBillMapper {

    @Select("select * from lz_user where id=#{id}")
    @Options(useCache = true)
    User getUser(@Param("id") Long id);

}
