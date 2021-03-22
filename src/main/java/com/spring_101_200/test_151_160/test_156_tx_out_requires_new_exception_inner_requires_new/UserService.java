package com.spring_101_200.test_151_160.test_156_tx_out_requires_new_exception_inner_requires_new;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserRequiresNew2();
}