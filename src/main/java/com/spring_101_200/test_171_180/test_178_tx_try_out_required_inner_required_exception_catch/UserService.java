package com.spring_101_200.test_171_180.test_178_tx_try_out_required_inner_required_exception_catch;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);



    void updateUserRequireThrowException2();
}