package com.junshijun.hub.idea.security.utils;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.junshijun.hub.idea.config.JwtConfig;
import com.junshijun.hub.idea.entity.SysUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

/**
 * Jwt Token工具类
 */
@Slf4j
public class JwtTokenUtils {

    /**
     * 创建Token
     *
     * @param sysUserDetails
     * @return
     */
    public static String createAccessToken(SysUserDetails sysUserDetails) {
        String token = Jwts.builder()
                .setId(sysUserDetails.getUserId().toString())
                .setSubject(sysUserDetails.getLoginName())
                .setIssuedAt(new Date())
                .setIssuer(sysUserDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + JwtConfig.expiration))
                .signWith(SignatureAlgorithm.HS512, JwtConfig.secret)
                .claim("authorities", JSONUtil.toJsonStr(sysUserDetails.getAuthorities()))
                .compact();
        return JwtConfig.tokenPrefix + token;
    }

    /**
     * 解析Token
     *
     * @param token
     * @return
     */
    public static SysUserDetails parseAccessToken(String token) {
        if (StrUtil.isEmpty(token)) {
            return null;
        }
        SysUserDetails sysUserDetails = null;
        try {
            token = token.substring(JwtConfig.tokenPrefix.length());

            Claims claims = Jwts.parser().setSigningKey(JwtConfig.secret).parseClaimsJws(token).getBody();

            sysUserDetails = new SysUserDetails();
            sysUserDetails.setUserId(Long.valueOf(claims.getId()));
            sysUserDetails.setLoginName(claims.getSubject());
            // 获取角色
            Set<GrantedAuthority> authorities = new HashSet();
            String authority = claims.get("authorities").toString();
            if (StrUtil.isNotEmpty(authority)) {
                List<Map<String, String>> authorityList = JSONUtil.toBean(authority,
                        new TypeReference<List<Map<String, String>>>() {
                        }, false);
                for (Map<String, String> role : authorityList) {
                    if (!role.isEmpty()) {
                        authorities.add(new SimpleGrantedAuthority(role.get("authority")));
                    }
                }
            }
            sysUserDetails.setAuthorities(authorities);
        } catch (Exception e) {
            log.error("An Exception Occurred On Parsing Jwt Token: " + e);
        }
        return sysUserDetails;
    }
}
