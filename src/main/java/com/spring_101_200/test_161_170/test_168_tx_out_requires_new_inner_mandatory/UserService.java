package com.spring_101_200.test_161_170.test_168_tx_out_requires_new_inner_mandatory;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserMandatory();
}