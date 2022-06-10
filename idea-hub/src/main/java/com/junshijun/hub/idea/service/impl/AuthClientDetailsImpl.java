package com.junshijun.hub.idea.service.impl;

import com.junshijun.hub.idea.converter.AuthClientDetailConverter;
import com.junshijun.hub.idea.entity.OauthClientDetail;
import com.junshijun.hub.idea.service.AuthClientDetailsService;
import com.junshijun.hub.idea.service.SysAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Primary
@Slf4j
public class AuthClientDetailsImpl implements AuthClientDetailsService {

    @Resource
    private SysAuthService sysAuthService;

    @Resource
    private AuthClientDetailConverter authClientDetailConverter;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        OauthClientDetail oauthClientDetail = sysAuthService.getOauthClientDetailByClientId(clientId);
        if (oauthClientDetail == null) {
            throw new NoSuchClientException("Client " + clientId + " not have been configured");
        }
        BaseClientDetails resClientDetails = authClientDetailConverter.toBaseClientDetails(oauthClientDetail);
        return resClientDetails;
    }
}
