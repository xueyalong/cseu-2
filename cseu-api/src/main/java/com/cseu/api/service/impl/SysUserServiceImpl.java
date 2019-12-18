package com.cseu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.cseu.api.mapper.SysUserMapper;
import com.cseu.api.service.ISysUserService;
import com.cseu.common.annotation.Lock;
import com.cseu.common.annotation.Log;
import com.cseu.core.model.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Service
@Transactional
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    @Log(desc = "测试", type = 1, value = "1")
    @Lock(model = "user:", key = "userId:", locktime = 60)
    public boolean save(SysUser sysUser) {
        sysUser.setDelFlag("2");
        return sysUserMapper.insert(sysUser) > 0 ? true : false;
    }
}
