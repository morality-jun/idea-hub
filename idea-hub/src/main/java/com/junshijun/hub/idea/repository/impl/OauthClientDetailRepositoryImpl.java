package com.junshijun.hub.idea.repository.impl;

import com.junshijun.hub.idea.entity.OauthClientDetail;
import com.junshijun.hub.idea.mapper.OauthClientDetailMapper;
import com.junshijun.hub.idea.repository.OauthClientDetailRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Oauth的Client信息表 服务实现类
 * </p>
 *
 * @author 节操君
 * @since 2022-06-10
 */
@Service
public class OauthClientDetailRepositoryImpl extends ServiceImpl<OauthClientDetailMapper, OauthClientDetail> implements OauthClientDetailRepository {

}
