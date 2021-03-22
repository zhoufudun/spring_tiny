package com.spring_1_100.test_71_80.test78_spring_rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xuexiaolei
 * @version 2017年08月22日
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
                "classpath:spring_1_100/config_71_80/spring78_rabbitmq/spring78_mq.xml"})
public class MQProducerImplTest {
    @Autowired
    MQProducer mqProducer;

    final String queue_key = "test_queue_key";

    @Test
    public void sendDataToQueue() throws Exception {

        Map<String,Object> msg = new HashMap();
        msg.put("data","hello,rabbmitmq!");
        mqProducer.sendDataToQueue(queue_key, msg);
    }

}