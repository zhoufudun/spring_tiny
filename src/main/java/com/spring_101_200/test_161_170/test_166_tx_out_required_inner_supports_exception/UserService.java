package com.spring_101_200.test_161_170.test_166_tx_out_required_inner_supports_exception;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);

    void updateUserSupportsException();
}