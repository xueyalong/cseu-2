package com.cseu.api.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cseu.api.mapper.SysDeptMapper;
import com.cseu.api.service.ISysDeptService;
import com.cseu.core.model.SysDept;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门管理 服务实现类
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

}
