package com.spring_101_200.test_151_160.test_160_tx_out_required_exception_inner_required;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);

    void updateUserRequires2();
}