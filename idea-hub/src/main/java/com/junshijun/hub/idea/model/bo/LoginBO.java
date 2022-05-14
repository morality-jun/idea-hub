package com.junshijun.hub.idea.model.bo;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class LoginBO implements Serializable {

    @NotBlank
    @JsonAlias("login_name")
    private String loginName;

    @NotBlank
    @JsonAlias("password")
    private String password;
}
