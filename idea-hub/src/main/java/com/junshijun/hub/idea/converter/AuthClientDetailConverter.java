package com.junshijun.hub.idea.converter;

import com.junshijun.hub.idea.entity.OauthClientDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthClientDetailConverter {

    @Mappings({
            @Mapping(target = "scope", expression = "java(scopeConvert(oauthClientDetail.getScope()))"),
            @Mapping(target = "authorizedGrantTypes", expression = "java(authorizedGrantTypesConvert(oauthClientDetail.getAuthorizedGrantTypes()))"),
            @Mapping(target = "registeredRedirectUris", expression = "java(webServerRedirectUrisConvert(oauthClientDetail.getWebServerRedirectUris()))"),

    })
    BaseClientDetails toBaseClientDetails(OauthClientDetail oauthClientDetail);

    default Set<String> scopeConvert(String scopes) {
        if (StringUtils.isEmpty(scopes)) {
            return Collections.emptySet();
        }
        return Arrays.stream(scopes.split(",")).collect(Collectors.toSet());
    }

    default Set<String> authorizedGrantTypesConvert(String authorizedGrantTypes) {
        if (StringUtils.isEmpty(authorizedGrantTypes)) {
            return Collections.emptySet();
        }
        return Arrays.stream(authorizedGrantTypes.split(",")).collect(Collectors.toSet());
    }

    default Set<String> webServerRedirectUrisConvert(String webServerRedirectUris) {
        if (StringUtils.isEmpty(webServerRedirectUris)) {
            return Collections.emptySet();
        }
        return Arrays.stream(webServerRedirectUris.split(",")).collect(Collectors.toSet());
    }
}
