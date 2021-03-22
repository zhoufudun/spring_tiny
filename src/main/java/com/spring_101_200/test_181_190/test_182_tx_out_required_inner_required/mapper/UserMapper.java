package com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required.mapper;


import com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required.User;

public interface UserMapper {


    User selectById(Long id);

    void updateById(User user);
}
