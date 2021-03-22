package com.spring_101_200.test_181_190.test_181_commit_rollback_listener;

import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class MyTransactionListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handlerTransactionCommit(MyTransactionEvent event) {
        if(event instanceof MyTransactionEvent){
            System.out.println("==========事件提交了===============" + event.getName());
        }
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handlerTransactionRollBack(MyTransactionEvent event) {
        if(event instanceof MyTransactionEvent){
            System.out.println("==========事务回滚了===============" + event.getName());
        }
    }




}