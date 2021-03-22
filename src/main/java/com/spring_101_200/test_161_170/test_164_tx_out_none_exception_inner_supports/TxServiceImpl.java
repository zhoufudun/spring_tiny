package com.spring_101_200.test_161_170.test_164_tx_out_none_exception_inner_supports;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("txService")
public class TxServiceImpl implements TxService {


    @Autowired
    private UserService userService;

    public void updateUserRequiresNewTest6(){
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);
        userService.updateUserSupports();
        int i = 0 ;
        int j = 0;
        int c = i / j ;
    }
}
