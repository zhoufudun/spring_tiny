package com.spring_101_200.test_141_150.test_145_mybatis_cachenamespaceref_xml;


import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {


    User getUser(@Param("id") Long id);

    User getUserByParameterMap(User user);


    List<User> getUserByCompx(@Param("id") Long id , @Param("userNameList") List<String> userNameList, @Param("isDelete") Integer isDelete);
}
