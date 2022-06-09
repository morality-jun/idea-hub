package com.junshijun.hub.idea.service.impl;

import com.junshijun.hub.idea.entity.SysRole;
import com.junshijun.hub.idea.entity.SysUser;
import com.junshijun.hub.idea.entity.SysUserDetails;
import com.junshijun.hub.idea.model.vo.AuthUserRolePermissionVO;
import com.junshijun.hub.idea.service.SysUserDetailsService;
import com.junshijun.hub.idea.service.SysAuthService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SysUserDetailsServiceImpl implements SysUserDetailsService {

    @Resource
    private SysAuthService sysAuthService;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        AuthUserRolePermissionVO userRolePermission = sysAuthService.getUserRolePermissionByLoginName(loginName);
        if (userRolePermission != null) {
            SysUserDetails sysUserDetails = new SysUserDetails();
            BeanUtils.copyProperties(userRolePermission, sysUserDetails);

            Set<GrantedAuthority> authorities = new HashSet<>();

            userRolePermission.getPermissionCodes().forEach(permissionCode -> {
                authorities.add(new SimpleGrantedAuthority(permissionCode));
            });

            sysUserDetails.setAuthorities(authorities);

            return sysUserDetails;
        }
        return null;
    }
}
