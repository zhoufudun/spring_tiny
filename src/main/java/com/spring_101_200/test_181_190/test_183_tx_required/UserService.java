package com.spring_101_200.test_181_190.test_183_tx_required;

public interface UserService {


    User selectById(Long id);

    void updateById(User user);


}