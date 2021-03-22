package com.spring_101_200.test_171_180.test_180_tx_required_try_required_exception_catch;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);




    void updateUserRequireThrowException4();
}