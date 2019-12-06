package com.cseu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cseu.api.mapper.SysLogMapper;
import com.cseu.api.service.ISysLogService;
import com.cseu.core.model.SysLog;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}
