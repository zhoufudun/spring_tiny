package com.spring_1_100.test_71_80.test78_spring_rabbitmq.spring6_tx_transaction;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class TransactionSevice {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static final String queue_key = "test_queue_key";

    @Transactional
    public void testTransaction(){
        Map<String, Object> msg = new HashMap();
        msg.put("data", "hello,rabbmitmq!");
        msg.put("time", System.currentTimeMillis());
        System.out.println("++++++++++++++++++++" + JSON.toJSONString(msg));
        rabbitTemplate.convertAndSend(queue_key, msg);
        int i = 0;
        int j = 1;
       int c = j / i;
    }
}
