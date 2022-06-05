package com.junshijun.cotroller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testOauth2")
public class TestOauth2Controller {

    @PostMapping("/hello")
    public String say(String name) {
        return "Hello folks! Oauth took effect!";
    }
}
