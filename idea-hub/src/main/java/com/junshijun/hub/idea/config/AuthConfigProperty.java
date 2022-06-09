package com.junshijun.hub.idea.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auth")
public class AuthConfigProperty {

    /**
     * 资源白名单，当中路径不鉴权
     */
    public static String[] resourceWhitelist;

    /**
     * Token过期时间（秒）
     */
    public static int tokenExpiredSecond;

    public void setTokenExpiredSecond(int tokenExpiredSecond) {
        AuthConfigProperty.tokenExpiredSecond = tokenExpiredSecond;
    }

    public void setResourceWhitelist(String[] resourceWhitelist) {
        AuthConfigProperty.resourceWhitelist = resourceWhitelist;
    }
}
