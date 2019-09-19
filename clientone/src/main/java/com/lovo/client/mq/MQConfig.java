package com.lovo.client.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    @Bean
    public ActiveMQQueue mqQueue(){
        return  new ActiveMQQueue("j171queue");
    }

    @Bean
    public ActiveMQTopic mqTopic(){
        return  new ActiveMQTopic("j171topic");
    }
}
