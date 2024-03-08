package com.oauth.oauth.controller;

import com.oauth.oauth.dao.LanguagesDAO;
import com.oauth.oauth.entity.Language;
import com.oauth.oauth.service.LanguageService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class HomePageController {

    @Autowired
    LanguageService languageService;
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

    @PostMapping("addLanguageList")
    public ResponseEntity<String> addLanguages(@RequestBody List<Language> languageList){
        boolean status=languageService.addLanguagesList(languageList);
        if(status) return new ResponseEntity<>("languagesList added successfully", HttpStatus.OK);

        return new ResponseEntity<>("unable to add language list", HttpStatus.OK);
    }
    @PostMapping("addLanguage")
    public ResponseEntity<String> addLanguage(@RequestBody Language language){
        boolean status=languageService.addLanguage(language);
        if(status) return new ResponseEntity<>("language added successfully", HttpStatus.OK);

        return new ResponseEntity<>("unable to add language", HttpStatus.OK);
    }
}
