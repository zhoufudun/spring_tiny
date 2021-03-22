package com.spring_101_200.test_171_180.test_177_tx_required_try_catch;



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
        try {
            User user1 = userService.selectById(456l);
            user1.setUsername("123");
            userService.updateById(user1);
            System.out.println("====================================");
            User user2 = userService.selectById(457l);
            user2.setUsername("456");
            userService.updateById(user2);

            int i = 0;
            int j = 0;
            int c = i / j;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
