package com.junshijun.hub.idea.security;

import com.junshijun.hub.idea.common.Response;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录处理类
 */
@Component
public class UserNotLoginHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e)
            throws IOException, ServletException {
        Response.responseByServlet(httpServletResponse, Response.response(401, "Not Logined!", e.getMessage()));
    }
}
