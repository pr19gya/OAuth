package com.oauth.oauth.controller;

import com.oauth.oauth.entity.Language;
import com.oauth.oauth.service.LanguageService;
import org.modelmapper.internal.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    LanguageService languageService;

    @QueryMapping("allLanguages")
    public List<Language> getAll(){
        return languageService.getAllLanguages();
    }

    @QueryMapping("findLanguageById")
    public Language get(@Argument String languageId){
        return languageService.getLanguageById(languageId);
    }
}
