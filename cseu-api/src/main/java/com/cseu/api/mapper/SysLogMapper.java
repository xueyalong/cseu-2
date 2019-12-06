package com.cseu.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cseu.core.model.SysLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 日志表 Mapper 接口
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

}
