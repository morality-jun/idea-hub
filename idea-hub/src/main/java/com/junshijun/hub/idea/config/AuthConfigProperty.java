package com.junshijun.hub.idea.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auth")
public class AuthConfigProperty {

    public static String[] resourceWhitelist;

    public void setResourceWhitelist(String[] resourceWhitelist) {
        AuthConfigProperty.resourceWhitelist = resourceWhitelist;
    }
}
