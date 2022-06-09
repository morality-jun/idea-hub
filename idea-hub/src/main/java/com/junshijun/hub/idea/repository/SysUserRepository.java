package com.junshijun.hub.idea.repository;

import com.junshijun.hub.idea.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.junshijun.hub.idea.model.vo.AuthUserRolePermissionVO;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 节操君
 * @since 2022-05-02
 */
public interface SysUserRepository extends IService<SysUser> {

    public Boolean removeByLoginName(String loginName);

    public SysUser getByLoginName(String loginName);

    public Boolean isLoginNameExist(String loginName);

    AuthUserRolePermissionVO getUserRolePermissionByLoginName(String loginName);
}
