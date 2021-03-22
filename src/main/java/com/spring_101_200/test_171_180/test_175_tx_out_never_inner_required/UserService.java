package com.spring_101_200.test_171_180.test_175_tx_out_never_inner_required;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);



    void updateUserRequires2();
}