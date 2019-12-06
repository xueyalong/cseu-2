package com.cseu.common.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xueylf
 * @title: LogAop
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/513:53
 * version 1.0
 */
@Aspect
@Slf4j
public class LogAop {


    //execution表达式自行搜索引擎
    @Pointcut("execution(* com.cseu.*.service.*.*(..))")
    public void log() {}


    @Before("log()")
    public void printParam(JoinPoint joinPoint){
        //获取请求的方法
        log.info("打印日志开始..........");
        Signature sig = joinPoint.getSignature();
        String method = joinPoint.getTarget().getClass().getName() + "." + sig.getName();

        //获取请求的参数
        Object[] args = joinPoint.getArgs();
        //fastjson转换
        String params = JSONObject.toJSONString(args);

        //打印请求参数
        log.info(method + ":" + params);
        log.info("打印日志结束..........");
    }
}
