package com.spring_101_200.test_151_160.test_160_tx_out_required_exception_inner_required;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("txService")
public class TxServiceImpl implements TxService {


    @Autowired
    private UserService userService;


    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserRequiresTest2(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserRequires2();
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }
}
