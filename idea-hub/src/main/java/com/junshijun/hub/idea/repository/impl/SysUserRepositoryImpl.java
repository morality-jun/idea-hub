package com.junshijun.hub.idea.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.junshijun.hub.idea.entity.SysUser;
import com.junshijun.hub.idea.mapper.SysUserMapper;
import com.junshijun.hub.idea.repository.SysUserRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 节操君
 * @since 2022-05-02
 */
@Service
public class SysUserRepositoryImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserRepository {

    @Override
    public Boolean removeByLoginName(String loginName) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getLoginName, loginName);
        return remove(wrapper);
    }

    @Override
    public SysUser findByLoginName(String loginName) {
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getLoginName, loginName);
        return getOne(wrapper);
    }
}
