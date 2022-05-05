package com.junshijun.hub.idea.security;

import com.junshijun.hub.idea.common.Response;
import com.junshijun.hub.idea.entity.SysUserDetails;
import com.junshijun.hub.idea.security.utils.JwtTokenUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登陆成功处理类
 */
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication)
            throws IOException, ServletException {
        SysUserDetails sysUserDetails = (SysUserDetails) authentication.getPrincipal();
        String token = JwtTokenUtils.createAccessToken(sysUserDetails);
        Map<String, String> tokenResultMap = new HashMap<>();
        tokenResultMap.put("token", token);
        Response.responseByServlet(httpServletResponse, Response.response(200, "Login Success!", tokenResultMap));
    }
}
