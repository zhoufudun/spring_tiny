package com.spring_101_200.test_161_170.test_163_tx_out_required_exception_inner_suports;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);

    void updateUserSupports();
}