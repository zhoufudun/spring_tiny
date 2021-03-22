package com.spring_101_200.test_161_170.test_170_tx_out_required_inner_mandatory;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


    void updateUserRequire123();

    void updateUserMandatory();
}