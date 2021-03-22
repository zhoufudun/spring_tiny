package com.spring_101_200.test_181_190.test_182_tx_out_required_inner_required;



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
    public void updateUserRequiresNewTest19() {
        User user1 = userService.selectById(456l);
        user1.setUsername("123");
        userService.updateById(user1);


      //  userService.updateUserRequireThrowException2();
    }

}
