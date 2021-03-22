package com.spring_101_200.test_141_150.test_149_mybatis_resultordered;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    List<User> getUser(@Param("id") Long id);


}
