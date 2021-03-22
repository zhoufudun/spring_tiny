package com.spring_101_200.test_181_190.test_183_tx_required;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface  TxService {


    @Transactional(propagation = Propagation.REQUIRED)
    void updateUserRequiresNewTest2222();
}
