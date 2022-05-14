package com.junshijun.hub.idea.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class LoginTokenDTO implements Serializable {

    private String token;
}
