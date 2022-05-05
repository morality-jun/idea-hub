package com.junshijun.hub.idea.security;

import com.junshijun.hub.idea.entity.SysUserDetails;
import com.junshijun.hub.idea.service.SysUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户登陆验证处理类
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Resource
    private SysUserDetailsService sysUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String loginName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        SysUserDetails sysUserDetails = (SysUserDetails) sysUserDetailsService.loadUserByUsername(loginName);
        if (sysUserDetails == null) {
            throw new UsernameNotFoundException("User Not Exist!");
        }
        if (!new BCryptPasswordEncoder().matches(password, sysUserDetails.getPassword())) {
            throw new BadCredentialsException("Login Name Or Password is Wrong!");
        }

        return new UsernamePasswordAuthenticationToken(sysUserDetails, password, sysUserDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
