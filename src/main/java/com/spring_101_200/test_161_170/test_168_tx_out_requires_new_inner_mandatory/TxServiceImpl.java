package com.spring_101_200.test_161_170.test_168_tx_out_requires_new_inner_mandatory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("txService")
public class TxServiceImpl implements TxService {


    @Autowired
    private UserService userService;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNewTest11(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserMandatory();
    }

}
