package com.cseu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cseu.api.mapper.ZipkinAnnotationsMapper;
import com.cseu.api.service.IZipkinAnnotationsService;
import com.cseu.core.model.ZipkinAnnotations;
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
public class ZipkinAnnotationsServiceImpl extends ServiceImpl<ZipkinAnnotationsMapper, ZipkinAnnotations> implements IZipkinAnnotationsService {

}
