package com.oauth.oauth.controller;

import jdk.jfr.Registered;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController

public class HomePageController {
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
//        return Collections.singletonMap("name", principal.getAttribute("name"));
        Map<String,Object> map=new HashMap<>();
        map.put("name",principal.getAttribute("name"));
        map.put("UserName",principal.getAttribute("login"));
        map.put("email",principal.getAttribute("email"));
        map.put("avatar_url",principal.getAttribute("avatar_url"));
        return map;
    }
}
