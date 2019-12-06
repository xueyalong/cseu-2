package com.cseu.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cseu.core.model.SysRoleDept;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色与部门对应关系 Mapper 接口
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Mapper
public interface SysRoleDeptMapper extends BaseMapper<SysRoleDept> {

}
