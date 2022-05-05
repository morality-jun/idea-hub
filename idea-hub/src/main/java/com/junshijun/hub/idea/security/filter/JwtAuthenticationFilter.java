package com.junshijun.hub.idea.security.filter;

import com.junshijun.hub.idea.config.JwtConfig;
import com.junshijun.hub.idea.entity.SysUserDetails;
import com.junshijun.hub.idea.security.utils.JwtTokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Jwt权限过滤器，用于验证
 **/
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws IOException, ServletException {

        String token = request.getHeader(JwtConfig.header);

        if (token != null && token.startsWith(JwtConfig.tokenPrefix)) {
            SysUserDetails sysUserDetails = JwtTokenUtils.parseAccessToken(token);

            if (sysUserDetails != null) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        sysUserDetails, sysUserDetails.getUserId(), sysUserDetails.getAuthorities()
                );
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
