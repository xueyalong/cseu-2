package com.cseu.common.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;

import java.util.Collections;

/**
 * @author xueylf
 * @title: RedisLock
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/515:24
 * version 1.0
 */
@Slf4j
public class RedisLock {

    private static final Long SUCCESS = 1L;

    private final static StringBuffer LOCKLUA = new StringBuffer("if redis.call('setNx',KEYS[1],ARGV[1]) then if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end end");


    private final static StringBuffer RELEASELUA = new StringBuffer("if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end");

    /**
     * 获取锁
     *
     * @param lockKey
     * @param value
     * @param expireTime：单位-秒
     * @return
     */
    public static boolean getLock(RedisTemplate redisTemplate, String lockKey, String value, int expireTime){
        boolean ret = false;
        log.info("get lock key is {},value is {}", lockKey, value);
        try {
            DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>(LOCKLUA.toString(), Long.class);
            Long result = (Long) redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value, String.valueOf(expireTime));
            if (SUCCESS.equals(result)) {
                log.info("lock result success");
                return true;
            }else{
                log.info("lock result failed");
            }
        } catch (Exception e) {
            log.info("failed get lock,reason is:", e);
        }
        return ret;
    }

    /**
     * 释放锁
     *
     * @param lockKey
     * @param value
     * @return
     */
    public static boolean releaseLock(RedisTemplate redisTemplate, String lockKey, String value) {
        log.info("release lock key is {},value is {}", lockKey, value);
        RedisScript<Long> redisScript = new DefaultRedisScript<>(RELEASELUA.toString(), Long.class);
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), value);
        if (SUCCESS.equals(result)) {
            log.info("release lock  success !" );
            return true;
        }else{
            log.info("release lock  failed !" );
        }
        return false;
    }


}
