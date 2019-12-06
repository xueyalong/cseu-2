package com.cseu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cseu.api.mapper.SysRoleDeptMapper;
import com.cseu.api.service.ISysRoleDeptService;
import com.cseu.core.model.SysRoleDept;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 角色与部门对应关系 服务实现类
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Service
@Transactional
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements ISysRoleDeptService {

}
