package com.junshijun.hub.idea.service.impl;

import com.junshijun.hub.idea.entity.SysPermission;
import com.junshijun.hub.idea.entity.SysRole;
import com.junshijun.hub.idea.entity.SysUser;
import com.junshijun.hub.idea.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Override
    public SysUser getUserByLoginName(String loginName) {
        return null;
    }

    @Override
    public List<SysRole> getRoleByUserId(Long userId) {
        return null;
    }

    @Override
    public List<SysPermission> getPermissionByUserId(Long userId) {
        return null;
    }
}
