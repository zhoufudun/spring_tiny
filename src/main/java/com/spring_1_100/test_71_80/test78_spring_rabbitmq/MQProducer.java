package com.spring_1_100.test_71_80.test78_spring_rabbitmq;

public interface MQProducer {
    public void sendDataToQueue(String queueKey, Object object);
}