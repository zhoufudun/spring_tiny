package com.spring_101_200.test_171_180.test_173_tx_out_none_inner_not_support_exception;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);

    void updateUserNotSupportException();
}