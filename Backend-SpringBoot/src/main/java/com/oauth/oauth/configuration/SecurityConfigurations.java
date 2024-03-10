package com.oauth.oauth.configuration;

import com.oauth.oauth.components.OAuth2LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations {
    @Autowired
    OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.csrf()
                .disable()
                .authorizeHttpRequests()
//                .requestMatchers("/addLanguageList","/addLanguage")
//                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .successHandler(oAuth2LoginSuccessHandler);



        return http.build();
    }
}
