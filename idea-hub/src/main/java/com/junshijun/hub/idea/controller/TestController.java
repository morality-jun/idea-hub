package com.junshijun.hub.idea.controller;

import com.junshijun.hub.idea.common.Response;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/all")
    @PreAuthorize(value = "@authenticator.hasPermission('all')")
    public Response all() {
        return Response.success(null);
    }

}
