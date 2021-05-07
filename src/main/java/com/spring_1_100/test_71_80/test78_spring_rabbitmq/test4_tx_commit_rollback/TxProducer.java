package com.spring_1_100.test_71_80.test78_spring_rabbitmq.test4_tx_commit_rollback;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.spring_1_100.test_71_80.test78_spring_rabbitmq.RabbitConstant;

public class TxProducer {

    private static final String QUEUE_NAME = "test_queue_tx";

    public static void main(String[] args) throws Exception {

        //1 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2 设置参数
        connectionFactory.setHost(RabbitConstant.HOST);//设置注解
        connectionFactory.setPort(RabbitConstant.PORT);//设置端口
        //connectionFactory.setVirtualHost(RabbitConstant.VHOST + "xxxx");//设置虚拟及
        connectionFactory.setVirtualHost(RabbitConstant.VHOST );//设置虚拟及
        connectionFactory.setUsername(RabbitConstant.USERNAME);
        connectionFactory.setPassword(RabbitConstant.PASSWORD);

        // 3 创建Channel
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for(int i = 0 ;i < 3 ;i ++ ){
            try {
                String msgString = "hello tx message ! " + i ;
                channel.txSelect();
                channel.basicPublish("", QUEUE_NAME, null, msgString.getBytes());
                if(i ==1 ){
                    int a = 1 / 0;
                }
                channel.txCommit();
                System.out.println("producer : " + msgString + " finished!");
            } catch (Exception e) {
                e.printStackTrace();
                channel.txRollback();
                System.out.println("producer message txRollback");
            }
        }
        channel.close();
        connection.close();
    }
}