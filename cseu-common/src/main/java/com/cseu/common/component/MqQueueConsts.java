package com.cseu.common.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author xueylf
 * @title: MqQueueConsts
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/2116:22
 * version 1.0
 */
@Slf4j
@Configuration
public class MqQueueConsts {
    @Bean
    public Queue testQueue() {
        return new Queue("TestDirectQueue", true);  //true 是否持久
    }

    @Bean
    DirectExchange TestDirectExchange() {
        return new DirectExchange("TestDirectExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingDirect() {
        return BindingBuilder.bind(testQueue()).to(TestDirectExchange()).with("TestDirectRouting");
    }

}
