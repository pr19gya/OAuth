package com.oauth.oauth.components;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class GeneralComponents {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
