package com.spring_101_200.test_171_180.test_176_tx_required_try_catch;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserNested2() throws Exception;
}