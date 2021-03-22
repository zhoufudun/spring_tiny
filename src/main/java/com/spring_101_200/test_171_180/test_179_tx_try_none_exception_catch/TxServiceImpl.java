package com.spring_101_200.test_171_180.test_179_tx_try_none_exception_catch;



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
    public void updateUserRequiresNewTest20() {
        try {
            User user1 = userService.selectById(456l);
            user1.setUsername("123");
            userService.updateById(user1);
            System.out.println("====================================");
            userService.updateUserRequireThrowException3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
