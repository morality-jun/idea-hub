package com.junshijun.hub.idea.service;

import com.junshijun.hub.idea.model.bo.RegisterBO;
import com.junshijun.hub.idea.entity.SysPermission;
import com.junshijun.hub.idea.entity.SysRole;
import com.junshijun.hub.idea.entity.SysUser;
import com.junshijun.hub.idea.model.dto.LoginTokenDTO;

import java.util.List;

public interface SysAuthService {

    LoginTokenDTO loginAndGetToken(String loginName, String password);

    /**
     * 查询用户名是否存在
     * @param loginName
     * @return
     */
    Boolean isLoginNameExist(String loginName);

    /**
     * 用户注册
     * @param registerInfo
     * @return
     */
    Boolean register(RegisterBO registerInfo);

    /**
     * 通过用户名查询用户信息
     * @param loginName
     * @return
     */
    SysUser getUserByLoginName(String loginName);

    /**
     * 通过用户主键查询角色
     * @param userId
     * @return
     */
    List<SysRole> getRoleByUserId(Long userId);

    /**
     * 通过用户主键查询权限
     * @param userId
     * @return
     */
    List<SysPermission> getPermissionByUserId(Long userId);
}
