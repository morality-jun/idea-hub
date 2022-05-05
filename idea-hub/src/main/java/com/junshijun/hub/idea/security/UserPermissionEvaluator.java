package com.junshijun.hub.idea.security;

import com.junshijun.hub.idea.entity.SysPermission;
import com.junshijun.hub.idea.entity.SysUserDetails;
import com.junshijun.hub.idea.service.SysAuthService;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 权限注解处理类
 */
@Component
public class UserPermissionEvaluator implements PermissionEvaluator {

    @Resource
    private SysAuthService sysAuthService;

    /**
     * 判断是否有权限
     * @param authentication
     * @param targetUrl
     * @param targetPermission
     * @return
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        SysUserDetails sysUserDetails = (SysUserDetails) authentication.getPrincipal();

        Set<String> permissions = new HashSet<>();

        List<SysPermission> permissionList = sysAuthService.getPermissionByUserId(sysUserDetails.getUserId());
        permissionList.forEach(permission -> {
            permissions.add(permission.getPermissionCode());
        });

        if (permissions.contains(targetPermission.toString())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
