package com.spring_101_200.test_151_160.test_158_tx_out_required_inner_requires_new_and_requires_new_exception;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserRequiresNew33();

    void updateUserRequiresNew1();
}