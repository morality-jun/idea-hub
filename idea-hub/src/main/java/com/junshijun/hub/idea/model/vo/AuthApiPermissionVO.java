package com.junshijun.hub.idea.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class AuthApiPermissionVO {

    private String apiCode;

    private String apiUrl;

    private List<String> permissionCodes;
}
