package com.junshijun.hub.idea.controller;

import com.junshijun.hub.idea.model.bo.LoginBO;
import com.junshijun.hub.idea.model.bo.RegisterBO;
import com.junshijun.hub.idea.common.Response;
import com.junshijun.hub.idea.model.dto.LoginTokenDTO;
import com.junshijun.hub.idea.service.SysAuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

@Slf4j
@Api(tags = "认证授权")
@RestController
@RequestMapping("/auth")
public class SysAuthController {

    @Resource
    private SysAuthService sysAuthService;

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public Response register(@RequestBody @Validated RegisterBO registerInfo) {
        return sysAuthService.register(registerInfo) ? Response.success(null) : Response.fail("System is Busy, Try it Later!");
    }

    @PostMapping("/login")
    @ApiOperation(value = "登陆")
    public Response<LoginTokenDTO> login(@RequestBody @Validated LoginBO loginInfo) {
        return Response.success(sysAuthService.loginAndGetToken(loginInfo));
    }
}
