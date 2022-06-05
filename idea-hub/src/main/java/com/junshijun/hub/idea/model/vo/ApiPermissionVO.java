package com.junshijun.hub.idea.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ApiPermissionVO {

    private String apiCode;

    private String apiUrl;

    private String permissionCode;
}
