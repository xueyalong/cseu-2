package com.cseu.api;

import com.cseu.common.aop.LockAop;
import com.cseu.common.aop.LogAop;
import com.cseu.common.component.ElasticSearchService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sun.awt.AppContext;

@SpringBootApplication
public class CseuApiApplication {

    @Bean
    public LockAop getLockAop() {
        return new LockAop();
    }

    @Bean
    public LogAop getLogAop() {
        return new LogAop();
    }
    @Bean
    public ElasticSearchService  getElasticSearchService() {
        return new ElasticSearchService();
    }
    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");

        SpringApplication.run(CseuApiApplication.class, args);

    }


}
