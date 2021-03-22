package com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required;

import com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService {




    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public void updateById(User user) {
        userMapper.updateById(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequireThrowException2() {
        User user2 = selectById(457l);
        user2.setUsername("456");
        updateById(user2);
    }

}
