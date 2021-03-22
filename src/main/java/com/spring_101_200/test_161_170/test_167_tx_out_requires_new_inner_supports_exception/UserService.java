package com.spring_101_200.test_161_170.test_167_tx_out_requires_new_inner_supports_exception;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserSupportsException();
}