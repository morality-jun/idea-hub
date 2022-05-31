package com.junshijun.hub.idea.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@Schema(description = "登陆Token信息")
public class LoginTokenDTO implements Serializable {

    @Schema(description = "Access Token")
    private String token;
}
