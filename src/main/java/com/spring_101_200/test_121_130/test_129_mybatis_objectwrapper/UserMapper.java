package com.spring_101_200.test_121_130.test_129_mybatis_objectwrapper;

import java.util.Map;

public interface UserMapper {

    void insertUser(User user);

   User getUser(Long id);

    Map<String, Object> getUserMap(long l);
}
