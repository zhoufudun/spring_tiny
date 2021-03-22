package com.spring_101_200.test_161_170.test_161_tx_out_required_inner_requires_new_exception;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);

    void updateUserRequires();
}