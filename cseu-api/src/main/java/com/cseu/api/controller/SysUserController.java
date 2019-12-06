package com.cseu.api.controller;

import com.cseu.api.service.ISysUserService;
import com.cseu.core.model.SysUser;
import com.cseu.core.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author xueylf
 * @title: SysUserController
 * @projectName cseu
 * @description: TODO
 * @date 2019/12/514:37
 * version 1.0
 */
@RestController
@RequestMapping("/")
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;


    @GetMapping("u")
    public Object getUser() {
        SnowflakeIdWorker snowflake = new SnowflakeIdWorker(1, 1);
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
        return  "success";
    }
}
