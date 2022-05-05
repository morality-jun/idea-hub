package com.junshijun.hub.idea.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.junshijun.hub.idea.entity.SysUserRole;
import com.junshijun.hub.idea.mapper.SysUserRoleMapper;
import com.junshijun.hub.idea.repository.SysUserRoleRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author 节操君
 * @since 2022-05-04
 */
@Service
public class SysUserRoleRepositoryImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleRepository {

    @Override
    public List<SysUserRole> listByUserId(Long userId) {
        LambdaQueryWrapper<SysUserRole> wrapper = new LambdaQueryWrapper();
        wrapper.eq(userId != null, SysUserRole::getUserId, userId);
        return list(wrapper);
    }
}
