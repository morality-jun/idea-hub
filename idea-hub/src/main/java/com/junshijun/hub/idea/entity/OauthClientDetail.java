package com.junshijun.hub.idea.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * Oauth的Client信息表
 * </p>
 *
 * @author 节操君
 * @since 2022-06-10
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("oauth_client_detail")
public class OauthClientDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "client_id", type = IdType.ASSIGN_ID)
    private String clientId;

    @TableField("resource_ids")
    private String resourceIds;

    @TableField("client_secret")
    private String clientSecret;

    @TableField("scope")
    private String scope;

    @TableField("authorized_grant_types")
    private String authorizedGrantTypes;

    @TableField("web_server_redirect_uris")
    private String webServerRedirectUris;

    @TableField("authorities")
    private String authorities;

    @TableField("access_token_validity_seconds")
    private Integer accessTokenValiditySeconds;

    @TableField("refresh_token_validity_seconds")
    private Integer refreshTokenValiditySeconds;

    @TableField("additional_information")
    private String additionalInformation;

    @TableField("autoapprove")
    private String autoapprove;

    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private Long createdBy;

    @TableField(value = "created_time", fill = FieldFill.INSERT)
    private LocalDateTime createdTime;

    @TableField(value = "modified_by", fill = FieldFill.UPDATE)
    private Long modifiedBy;

    @TableField(value = "modified_time", fill = FieldFill.UPDATE)
    private LocalDateTime modifiedTime;


    public static final String CLIENT_ID = "client_id";

    public static final String RESOURCE_IDS = "resource_ids";

    public static final String CLIENT_SECRET = "client_secret";

    public static final String SCOPE = "scope";

    public static final String AUTHORIZED_GRANT_TYPES = "authorized_grant_types";

    public static final String WEB_SERVER_REDIRECT_URI = "web_server_redirect_uri";

    public static final String AUTHORITIES = "authorities";

    public static final String ACCESS_TOKEN_VALIDITY = "access_token_validity";

    public static final String REFRESH_TOKEN_VALIDITY = "refresh_token_validity";

    public static final String ADDITIONAL_INFORMATION = "additional_information";

    public static final String AUTOAPPROVE = "autoapprove";

    public static final String IS_DELETED = "is_deleted";

    public static final String CREATED_BY = "created_by";

    public static final String CREATED_TIME = "created_time";

    public static final String MODIFIED_BY = "modified_by";

    public static final String MODIFIED_TIME = "modified_time";

}
