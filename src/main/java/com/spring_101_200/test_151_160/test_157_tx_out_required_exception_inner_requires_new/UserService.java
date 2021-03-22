package com.spring_101_200.test_151_160.test_157_tx_out_required_exception_inner_requires_new;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserRequiresNew2();
}