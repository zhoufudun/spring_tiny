package com.spring_101_200.test_171_180.test_174_tx_out_required_inner_never;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);




    void updateUserNever();
}