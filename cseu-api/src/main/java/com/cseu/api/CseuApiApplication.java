package com.cseu.api;

import com.cseu.common.aop.LockAop;
import com.cseu.common.aop.LogAop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(CseuApiApplication.class, args);
    }


}
