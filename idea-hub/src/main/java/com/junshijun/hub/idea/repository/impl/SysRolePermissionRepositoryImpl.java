package com.junshijun.hub.idea.repository.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.junshijun.hub.idea.entity.SysRolePermission;
import com.junshijun.hub.idea.mapper.SysRolePermissionMapper;
import com.junshijun.hub.idea.repository.SysRolePermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色权限关联表 服务实现类
 * </p>
 *
 * @author 节操君
 * @since 2022-05-04
 */
@Service
public class SysRolePermissionRepositoryImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionRepository {

    @Override
    public List<SysRolePermission> listByRoleIds(List<Long> roleIds) {
        LambdaQueryWrapper<SysRolePermission> wrapper = new LambdaQueryWrapper();
        wrapper.in(CollectionUtil.isNotEmpty(roleIds), SysRolePermission::getRoleId, roleIds);
        return list(wrapper);
    }
}
