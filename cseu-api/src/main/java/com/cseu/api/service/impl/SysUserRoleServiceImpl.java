package com.cseu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cseu.api.mapper.SysUserRoleMapper;
import com.cseu.api.service.ISysUserRoleService;
import com.cseu.core.model.SysUserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Service
@Transactional
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

}
