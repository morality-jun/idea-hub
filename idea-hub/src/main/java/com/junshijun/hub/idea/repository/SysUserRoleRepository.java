package com.junshijun.hub.idea.repository;

import com.junshijun.hub.idea.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author 节操君
 * @since 2022-05-04
 */
public interface SysUserRoleRepository extends IService<SysUserRole> {

    List<SysUserRole> listByUserId(Long userId);
}
