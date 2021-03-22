package com.spring_101_200.test_161_170.test_165_tx_out_none_inner_supports_exception;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserSupportsException();
}