package com.spring_101_200.test_151_160.test_155_tx_out_requires_new_inner_requires_new_exception;

import com.spring_101_200.test_181_190.test_181_commit_rollback_listener.MyTransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("txService")
public class TxServiceImpl implements TxService {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUserRequiresNewTest1() {
        User user1 = userService.selectById(456l);
        user1.setUsername("12323232323");
        userService.updateById(user1);
        userService.updateUserRequiresNew1();
    }

}
