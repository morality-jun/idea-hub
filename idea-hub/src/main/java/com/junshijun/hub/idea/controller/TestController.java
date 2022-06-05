package com.junshijun.hub.idea.controller;

import com.junshijun.hub.idea.common.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Api(tags = "测试")
public class TestController {

    @GetMapping("/all")
    @PreAuthorize(value = "@authenticator.hasPermission('ROLE_super_admin')")
    @ApiOperation("测试接口")
    public Response all() {
        return Response.success(null);
    }

}
