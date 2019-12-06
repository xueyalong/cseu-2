package com.cseu.api;


import com.cseu.api.service.ISysUserService;
import com.cseu.core.model.SysUser;
import com.cseu.core.utils.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@SpringBootTest(classes = CseuApiApplication.class)
public class CseuApiApplicationTests {

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test

    public void demo() {
        run();

    }

    public void run() {
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(5);
        AtomicLong time = new AtomicLong(0);
        long start=System.currentTimeMillis();

//        for (int i = 1; i <= 1; i++) {
//            fixedExecutorService.execute(() -> {
//                try {
//                    Thread.sleep(100L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                Random random=new Random();
                Integer tep=random.nextInt(5);
                SnowflakeIdWorker snowflake = new SnowflakeIdWorker(tep, tep);
                SysUser sysUser = SysUser.builder()
                        .userId(snowflake.nextId())
                        .createTime(new Date(System.currentTimeMillis()))
                        .delFlag("9")
                        .deptId(1)
                        .lockFlag("1")
                        .username("xueyl")
                        .password("123456")
                        .build();
                iSysUserService.save(sysUser);
//                time.addAndGet(1);
//                log.info("time={}", time);
//            });
//        }
//        fixedExecutorService.shutdown();
//        while (true) {
//            if (fixedExecutorService.isTerminated()) {
//                break;
//            }
//        }
    }


}

