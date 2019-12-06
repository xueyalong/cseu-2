package com.cseu.api.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cseu.api.mapper.SysOauthClientDetailsMapper;
import com.cseu.api.service.ISysOauthClientDetailsService;
import com.cseu.core.model.SysOauthClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 终端信息表 服务实现类
 * </p>
 *
 * @author bzcoder
 * @since 2019-12-04
 */
@Service
@Transactional
public class SysOauthClientDetailsServiceImpl extends ServiceImpl<SysOauthClientDetailsMapper, SysOauthClientDetails> implements ISysOauthClientDetailsService {

}
