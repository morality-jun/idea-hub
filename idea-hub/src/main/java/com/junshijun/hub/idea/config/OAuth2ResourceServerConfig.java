package com.junshijun.hub.idea.config;

import com.junshijun.hub.idea.model.vo.ApiPermissionVO;
import com.junshijun.hub.idea.service.SysApiService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private SysApiService sysApiService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        List<ApiPermissionVO> apiPermissionList = sysApiService.findAllApiPermission();

        http.authorizeRequests()
                .antMatchers("/test/**").hasAuthority("ROLE_super_admin")
                .anyRequest().authenticated();
    }
}
