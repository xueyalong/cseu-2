package com.cseu.common.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xueylf
 * @title: MessageListenerConfig
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/2117:10
 * version 1.0
 */
@Configuration
public class MessageListenerConfig {
    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setConcurrentConsumers(1);
        container.setMaxConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // RabbitMQ默认是自动确认，这里改为手动确认消息
        return container;
    }

}
