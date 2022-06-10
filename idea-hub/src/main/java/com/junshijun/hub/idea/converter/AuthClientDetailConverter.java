package com.junshijun.hub.idea.converter;

import com.junshijun.hub.idea.entity.OauthClientDetail;
import org.codehaus.jackson.map.ObjectMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthClientDetailConverter {

    @Mappings({
            @Mapping(target = "scope", expression = "java(scopeConvert(oauthClientDetail.getScope()))"),
            @Mapping(target = "authorizedGrantTypes", expression = "java(authorizedGrantTypesConvert(oauthClientDetail.getAuthorizedGrantTypes()))"),
            @Mapping(target = "registeredRedirectUri", expression = "java(webServerRedirectUrisConvert(oauthClientDetail.getWebServerRedirectUris()))"),
            @Mapping(target = "authorities", expression = "java(authoritiesConvert(oauthClientDetail.getAuthorities()))"),
            @Mapping(target = "additionalInformation", expression = "java(additionalInformationConvert(oauthClientDetail.getAdditionalInformation()))"),
            @Mapping(target = "resourceIds", expression = "java(resourceIdsConvert(oauthClientDetail.getResourceIds()))"),
            @Mapping(target = "autoApproveScopes", expression = "java(autoApproveScopesConvert(oauthClientDetail.getAutoapprove()))")
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

    default List<GrantedAuthority> authoritiesConvert(String authorities) {
        if (StringUtils.isEmpty(authorities)) {
            return Collections.emptyList();
        }
        return Arrays.stream(authorities.split(",")).map(item -> new SimpleGrantedAuthority(item)).collect(Collectors.toList());
    }

    default Map<String, Object> additionalInformationConvert(String additionalInformation) {
        Map<String, Object> res = null;
        try {
            if (StringUtils.isEmpty(additionalInformation)) {
                return Collections.emptyMap();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            res = objectMapper.readValue(additionalInformation, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res == null ? Collections.emptyMap() : res;
    }

    default Set<String> resourceIdsConvert(String resourceIds) {
        if (StringUtils.isEmpty(resourceIds)) {
            return Collections.emptySet();
        }
        return Arrays.stream(resourceIds.split(",")).collect(Collectors.toSet());
    }

    default Set<String> autoApproveScopesConvert(String autoApproveScopes) {
        if (StringUtils.isEmpty(autoApproveScopes)) {
            return Collections.emptySet();
        }
        return Arrays.stream(autoApproveScopes.split(",")).collect(Collectors.toSet());
    }
}
