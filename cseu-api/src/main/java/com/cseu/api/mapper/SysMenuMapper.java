package com.cseu.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cseu.core.model.SysMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

}
