package com.junshijun.hub.idea.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junshijun.hub.idea.entity.SysUser;
import com.junshijun.hub.idea.mapper.SysUserMapper;
import com.junshijun.hub.idea.model.vo.AuthUserRolePermissionVO;
import com.junshijun.hub.idea.repository.SysUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public Boolean removeByLoginName(String loginName) {
        if (loginName == null) {
            return null;
        }
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getLoginName, loginName);
        return remove(wrapper);
    }

    @Override
    public SysUser getByLoginName(String loginName) {
        if (loginName == null) {
            return null;
        }
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getLoginName, loginName);
        return getOne(wrapper);
    }

    @Override
    public Boolean isLoginNameExist(String loginName) {
        if (loginName == null) {
            return Boolean.FALSE;
        }
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getLoginName, loginName);
        return count(wrapper) > 0 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public AuthUserRolePermissionVO getUserRolePermissionByLoginName(String loginName) {
        if (loginName == null) {
            return null;
        }
        return sysUserMapper.getUserRolePermissionByLoginName(loginName);
    }
}
