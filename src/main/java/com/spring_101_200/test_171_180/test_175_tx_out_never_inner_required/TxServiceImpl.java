package com.spring_101_200.test_171_180.test_175_tx_out_never_inner_required;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("txService")
public class TxServiceImpl implements TxService {


    @Autowired
    private UserService userService;


    @Transactional(propagation = Propagation.NEVER)
    @Override
    public void updateUserRequiresNewTest17() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequires2();
    }

}
