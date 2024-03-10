package com.oauth.oauth.components;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class GeneralComponents {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }



}
