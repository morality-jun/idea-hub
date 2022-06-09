package com.junshijun.hub.idea.config;

import com.junshijun.hub.idea.security.CustomFilterSecurityInterceptor;
import com.junshijun.hub.idea.security.UserNotLoginHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Resource
    private CustomFilterSecurityInterceptor customFilterSecurityInterceptor;

    @Resource
    private UserNotLoginHandler userNotLoginHandler;

    private String[] resourceWhitelist = AuthConfigProperty.resourceWhitelist;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(customFilterSecurityInterceptor, FilterSecurityInterceptor.class)
                .authorizeRequests()
                .antMatchers(this.resourceWhitelist).permitAll()
                .anyRequest().authenticated()
                .and().httpBasic().authenticationEntryPoint(userNotLoginHandler);
    }
}
