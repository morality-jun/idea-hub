package com.junshijun.hub.idea.model.bo;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@Schema(description = "注册信息入参")
public class RegisterBO implements Serializable {

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9_-]{8,16}$")
    @JsonAlias("login_name")
    @Schema(description = "用户名")
    private String loginName;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9_-]{6,18}$")
    @JsonAlias("password")
    @Schema(description = "密码")
    private String password;
}
