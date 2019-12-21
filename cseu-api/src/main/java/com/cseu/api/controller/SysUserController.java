package com.cseu.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.cseu.api.service.ISysUserService;
import com.cseu.common.component.ElasticSearchService;
import com.cseu.common.core.SysUserEs;
import com.cseu.core.model.SysUser;
import com.cseu.core.utils.SnowflakeIdWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

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
@Slf4j
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private ElasticSearchService elasticSearchService;


    @GetMapping("u")
    public Object getUser() {
        SnowflakeIdWorker snowflake = new SnowflakeIdWorker(1, 1);
        for(int i=0;i<1000000;i++){
            SysUserEs sysUser = SysUserEs.builder()
                    .id(snowflake.nextId())
                    .createTime(new Date(System.currentTimeMillis()))
                    .delFlag(9)
                    .deptId(1L)
                    .lockFlag(1)
                    .username("xueyl")
                    .build();
            elasticSearchService.insertOrUpdateOne("sys_user",JSONObject.toJavaObject(JSONObject.parseObject(JSONObject.toJSONString(sysUser)),Map.class));
        }
        return "success";
    }

    @PostMapping(value = "u2")
    public Object user(@RequestBody Map<String, Object> data) {
        elasticSearchService.createIndex(MapUtils.getString(data, "idxName"), JSONObject.toJSONString(MapUtils.getMap(data, "idxSQL")));
        log.info("map={}", data);
        return "success";
    }
}
