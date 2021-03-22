package com.spring_101_200.test_171_180.test_172_tx_out_required_inner_not_supported_exception;


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
    public void updateUserRequiresNewTest144() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123huikaiming");
        userService.updateById(user1);
        userService.updateUserNotSupportException123();
    }

}
