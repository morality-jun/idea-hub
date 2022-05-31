package com.junshijun.hub.idea.model.bo;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Schema(description = "登陆信息入参")
public class LoginBO implements Serializable {

    @NotBlank
    @JsonAlias("login_name")
    @Schema(description = "用户名")
    private String loginName;

    @NotBlank
    @JsonAlias("password")
    @Schema(description = "密码")
    private String password;
}
