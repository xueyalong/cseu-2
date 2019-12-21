package com.cseu.api;

import com.cseu.common.aop.LockAop;
import com.cseu.common.aop.LogAop;
import com.cseu.common.component.ElasticSearchService;
import com.cseu.common.component.MqQueueConsts;
import com.cseu.common.config.MessageListenerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import sun.awt.AppContext;

@SpringBootApplication
@ImportAutoConfiguration({MessageListenerConfig.class, MqQueueConsts.class})
public class CseuApiApplication {

    @Bean
    public LockAop getLockAop() {
        return new LockAop();
    }

    @Bean
    public MqQueueConsts getMqQueueConsts() {
        return new MqQueueConsts();
    }

    @Bean
    public LogAop getLogAop() {
        return new LogAop();
    }

    @Bean
    public ElasticSearchService getElasticSearchService() {
        return new ElasticSearchService();
    }

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(CseuApiApplication.class, args);

    }


}
