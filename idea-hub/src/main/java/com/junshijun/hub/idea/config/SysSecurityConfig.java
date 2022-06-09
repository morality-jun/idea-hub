package com.junshijun.hub.idea.config;

import com.junshijun.hub.idea.security.*;
import com.junshijun.hub.idea.security.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SysSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 无权限处理类
     */
    @Resource
    private UserAccessDeniedHandler userAccessDeniedHandler;

    /**
     * 用户未登录处理类
     */
    @Resource
    private UserNotLoginHandler userNotLoginHandler;

    /**
     * 用户登录成功处理类
     */
    @Resource
    private UserLoginSuccessHandler userLoginSuccessHandler;

    /**
     * 用户登录失败处理类
     */
    @Resource
    private UserLoginFailureHandler userLoginFailureHandler;

    /**
     * 用户登出成功处理类
     */
    @Resource
    private UserLogoutSuccessHandler userLogoutSuccessHandler;

    /**
     * 用户登录验证
     */
    @Resource
    private UserAuthenticationProvider userAuthenticationProvider;

    /**
     * 用户权限注解
     */
    @Resource
    private UserPermissionEvaluator userPermissionEvaluator;

    private String[] antMatcherUrls = JwtConfig.antMatchers.split(",");

    private static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui.html/**",
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/swagger-config",
            "/webjars/**",
            "/doc.html",
    };

    private static final String[] OAUTH_WHITELIST = {
      "/oauth/token"
    };

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 接口权限验证
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityExpressionHandler userSecurityExpressionHandler() {
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(userPermissionEvaluator);
        return handler;
    }

    /**
     * 用户登陆验证
     *
     * @param auth
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(userAuthenticationProvider);
    }

//    @Override
//    public void configure(WebSecurity webSecurity) {
//        webSecurity.ignoring().antMatchers(antMatcherUrls);
//    }

    /**
     * 安全权限配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 权限配置
                .antMatchers(antMatcherUrls).anonymous()
                .antMatchers(SWAGGER_WHITELIST).anonymous() // 获取白名单（不进行权限验证）
                .antMatchers(OAUTH_WHITELIST).anonymous()
                .anyRequest().authenticated() // 其他的需要登陆后才能访问
                .and().httpBasic().authenticationEntryPoint(userNotLoginHandler) // 配置未登录处理类
                .and().logout().logoutUrl("/auth/logout")// 配置登出地址
                .logoutSuccessHandler(userLogoutSuccessHandler) // 配置用户登出处理类
                .and().exceptionHandling().accessDeniedHandler(userAccessDeniedHandler)// 配置没有权限处理类
                .and().cors()// 开启跨域
                .and().csrf().disable() // 禁用跨站请求伪造防护
                .addFilter(new JwtAuthenticationFilter(authenticationManager()));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 禁用session（使用Token认证）
        http.headers().cacheControl(); // 禁用缓存
    }

}
