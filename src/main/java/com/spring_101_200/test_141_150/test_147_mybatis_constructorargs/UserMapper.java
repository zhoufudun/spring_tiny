package com.spring_101_200.test_141_150.test_147_mybatis_constructorargs;


import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @ConstructorArgs({
            @Arg(column = "id", javaType = Long.class),
            @Arg(column = "is_delete", javaType = Integer.class)
    })
    @Select("select * from lz_user where id = #{id}")
    User getUser(Long id);



    User getUserById(long id);


    UserBill getUserBillById(@Param("id") Long id );


    UserBillInfo getUserBillResultMapById(Long id);
}
