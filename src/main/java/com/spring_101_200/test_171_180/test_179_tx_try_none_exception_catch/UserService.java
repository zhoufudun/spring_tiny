package com.spring_101_200.test_171_180.test_179_tx_try_none_exception_catch;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);

    void updateUserRequireThrowException3();
}