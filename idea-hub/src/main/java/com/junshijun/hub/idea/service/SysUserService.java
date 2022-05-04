package com.junshijun.hub.idea.service;

import com.junshijun.hub.idea.entity.SysUser;

public interface SysUserService {

    /**
     * 通过用户名查询用户信息
     * @param loginName
     * @return
     */
    SysUser getUserByLoginName(String loginName);

    /**
     * 通过用户主键查询用户信息
     * @param userId
     * @return
     */
    SysUser getUserById(Long userId);


}
