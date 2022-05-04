package com.junshijun.hub.idea.service.impl;

import com.junshijun.hub.idea.entity.SysRole;
import com.junshijun.hub.idea.entity.SysUser;
import com.junshijun.hub.idea.entity.SysUserDetails;
import com.junshijun.hub.idea.service.SysUserDetailsService;
import com.junshijun.hub.idea.service.SysUserService;
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
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        SysUser sysUser = sysUserService.getUserByLoginName(loginName);
        if (sysUser != null) {
            SysUserDetails sysUserDetails = new SysUserDetails();
            BeanUtils.copyProperties(sysUser, sysUserDetails);

            Set<GrantedAuthority> authorities = new HashSet<>();
            List<SysRole> sysRoles = sysUserService.getRoleByUserId(sysUser.getUserId());
            sysRoles.forEach(sysRole -> {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + sysRole.getRoleCode()));
            });

            sysUserDetails.setAuthorities(authorities);

            return sysUserDetails;
        }
        return null;
    }
}
