package com.junshijun.hub.idea.repository;

import com.junshijun.hub.idea.entity.SysRole;
import com.junshijun.hub.idea.entity.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色权限关联表 服务类
 * </p>
 *
 * @author 节操君
 * @since 2022-05-04
 */
public interface SysRolePermissionRepository extends IService<SysRolePermission> {

    List<SysRolePermission> listByRoleIds(List<Long> roleIds);
}
