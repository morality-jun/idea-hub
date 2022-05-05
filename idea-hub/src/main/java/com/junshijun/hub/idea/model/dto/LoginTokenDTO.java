package com.junshijun.hub.idea.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginTokenDTO implements Serializable {

    private String token;
}
