package com.spring_101_200.test_171_180.test_171_tx_out_required_not_supported_exception;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserNotSupportException();
}