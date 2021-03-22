package com.spring_101_200.test_161_170.test_170_tx_out_required_inner_mandatory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("txService")
public class TxServiceImpl implements TxService {


    @Autowired
    private UserService userService;


    public void updateUserRequiresNewTest13(){
        userService.updateUserRequire123();
        userService.updateUserMandatory();
    }
}
