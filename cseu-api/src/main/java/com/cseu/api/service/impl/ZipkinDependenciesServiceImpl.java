package com.cseu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cseu.api.mapper.ZipkinDependenciesMapper;
import com.cseu.api.service.IZipkinDependenciesService;
import com.cseu.core.model.ZipkinDependencies;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Service
@Transactional
public class ZipkinDependenciesServiceImpl extends ServiceImpl<ZipkinDependenciesMapper, ZipkinDependencies> implements IZipkinDependenciesService {

}
