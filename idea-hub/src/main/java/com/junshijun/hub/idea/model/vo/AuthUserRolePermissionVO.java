package com.junshijun.hub.idea.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class AuthUserRolePermissionVO {

    private Long userId;

    private String loginName;

    private String password;

    private List<String> roleCodes;

    private List<String> permissionCodes;
}
