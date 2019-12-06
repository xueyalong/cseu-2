package com.cseu.api.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cseu.core.model.ZipkinDependencies;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Mapper
public interface ZipkinDependenciesMapper extends BaseMapper<ZipkinDependencies> {

}
