package com.junshijun.hub.idea.service.impl;

import com.junshijun.hub.idea.model.bo.RegisterBO;
import com.junshijun.hub.idea.common.exception.LoginNameExistException;
import com.junshijun.hub.idea.entity.*;
import com.junshijun.hub.idea.model.dto.LoginTokenDTO;
import com.junshijun.hub.idea.repository.*;
import com.junshijun.hub.idea.service.SysAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements SysAuthService {

    @Resource
    private SysUserRepository sysUserRepository;

    @Resource
    private SysRoleRepository sysRoleRepository;

    @Resource
    private SysPermissionRepository sysPermissionRepository;

    @Resource
    private SysUserRoleRepository sysUserRoleRepository;

    @Resource
    private SysRolePermissionRepository sysRolePermissionRepository;

    @Override
    public LoginTokenDTO loginAndGetToken(String loginName, String password) {
        return null;
    }

    @Override
    public Boolean isLoginNameExist(String loginName) {
        return sysUserRepository.isLoginNameExist(loginName);
    }

    @Override
    public Boolean register(RegisterBO registerInfo) {
        if (this.isLoginNameExist(registerInfo.getLoginName())) {
            throw new LoginNameExistException();
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(registerInfo.getPassword());
        registerInfo.setPassword(encodedPassword);

        SysUser newUser = new SysUser();
        BeanUtils.copyProperties(registerInfo, newUser);
        return sysUserRepository.save(newUser);
    }

    @Override
    public SysUser getUserByLoginName(String loginName) {
        return sysUserRepository.getByLoginName(loginName);
    }

    @Override
    public List<SysRole> getRoleByUserId(Long userId) {
        List<SysUserRole> sysUserRoles = sysUserRoleRepository.listByUserId(userId);
        List<Long> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        return sysRoleRepository.listByIds(roleIds);
    }

    @Override
    public List<SysPermission> getPermissionByUserId(Long userId) {
        List<SysUserRole> sysUserRoles = sysUserRoleRepository.listByUserId(userId);
        List<Long> roleIds = sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
        List<SysRolePermission> sysRolePermissions = sysRolePermissionRepository.listByRoleIds(roleIds);
        List<Long> permissionId = sysRolePermissions.stream().map(SysRolePermission::getRoleId).collect(Collectors.toList());
        return sysPermissionRepository.listByIds(permissionId);
    }
}
