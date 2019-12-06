package com.cseu.common.aop;

import com.cseu.common.annotation.MQ;
import com.cseu.common.exception.CseuException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xueylf
 * @title: MQAop
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/610:53
 * version 1.0
 */
@Slf4j
@Aspect
public class MQAop {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Pointcut("@annotation(mq)")
    public void annotationMq(MQ mq) {
    }
    @Around("annotationMq(mq)")
    public Object around(ProceedingJoinPoint pjp, MQ mq) throws Throwable {
        //获取请求方法
        Signature sig = pjp.getSignature();
        String method = pjp.getTarget().getClass().getName() + "." + sig.getName();
        if (StringUtils.isNotEmpty(mq.queue()) && StringUtils.isNotEmpty(mq.message())) {
            throw new CseuException(1, method + ":queue and message not empty!");
        }

        //获取请求的参数
        Object[] args = pjp.getArgs();
        log.info("mq 消息");
        return true;
    }

}
