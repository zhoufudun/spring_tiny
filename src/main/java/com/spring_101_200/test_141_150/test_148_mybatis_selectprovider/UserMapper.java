package com.spring_101_200.test_141_150.test_148_mybatis_selectprovider;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

public interface UserMapper {

    //@SelectProvider、@UpdateProvider、@InsertProvider和@DeleteProvider
    @SelectProvider(type = SqlProvider.class, method = "selectUser")
    //@ResultMap("BaseResultMap")
    @ResultType(User.class)
    User getUser(Long id);

    User selectSqlUserById(@Param("id") Long id);

}
