package com.cseu.common.aop;

import com.alibaba.fastjson.JSONObject;
import com.cseu.common.annotation.Lock;
import com.cseu.common.core.SysUserEs;
import com.cseu.common.exception.CseuException;
import com.cseu.common.lock.RedisLock;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author xueylf
 * @title: LockAop
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/515:05
 * version 1.0
 */
@Slf4j
@Aspect
public class LockAop {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;



    @Pointcut("@annotation(lock)")
    public void annotationLock(Lock lock) {
    }


    @Around("annotationLock(lock)")
    public Object around(ProceedingJoinPoint pjp, Lock lock) throws Throwable {
        //获取请求方法
        Signature sig = pjp.getSignature();
        String method = pjp.getTarget().getClass().getName() + "." + sig.getName();
        if (StringUtils.isEmpty(lock.key()) && StringUtils.isEmpty(lock.model())) {
            throw new CseuException(1, method + ":model and key is not empty!");
        }
        final String key = lock.key().replace(":", "");
        final int lockTime = lock.locktime();
        //获取请求的参数
        Object[] args = pjp.getArgs();
        List<Map> params = JSONObject.parseArray(JSONObject.toJSONString(args), Map.class);
        if (params != null && params.size() > 0) {
            params.forEach(map -> {
                String value = MapUtils.getString(map, key);
                final Map<String, Object> resultMap = Maps.newHashMap();
                if (RedisLock.getLock(redisTemplate, lock.model() + lock.key() + value, value, lockTime)) {
                    try {
                        Boolean result = (Boolean) pjp.proceed();
                        if (result) {
                            RedisLock.releaseLock(redisTemplate, lock.model() + lock.key() + value, value);
                        }
                        resultMap.put("result", result);
                    } catch (Throwable throwable) {
                        log.info("failed release lock ,message is:", throwable);
                    }
                }
            });
        }
        log.info("lokc {}={}",method,args);
        List<SysUserEs> sysUserEs = JSONObject.parseArray(JSONObject.toJSONString(args), SysUserEs.class);
        return true;
    }

}
