package com.spring_101_200.test_151_160.test_158_tx_out_required_inner_requires_new_and_requires_new_exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("txService")
public class TxServiceImpl implements TxService {


    @Autowired
    private UserService userService;


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserRequiresNewTest222() {
        User user1 = userService.selectById(458l);
        user1.setUsername("789");
        userService.updateById(user1);

        userService.updateUserRequiresNew33();
        userService.updateUserRequiresNew1();

    }

}
