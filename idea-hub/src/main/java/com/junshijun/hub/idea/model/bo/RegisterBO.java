package com.junshijun.hub.idea.model.bo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RegisterBO {

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9_-]{3,16}$")
    @JsonAlias("login_name")
    private String loginName;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9_-]{6,18}$")
    @JsonAlias("password")
    private String password;
}
