package com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);



    void updateUserRequireThrowException2();
}