package com.oauth.oauth.configuration;

import com.oauth.oauth.components.OAuth2LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations {

    @Value("${loginPageUrl}")
    String loginPageUrl;
    @Autowired
    OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.cors().and()
                .csrf()
                .disable()
                .authorizeHttpRequests()
//                .requestMatchers("/addLanguageList","/addLanguage")
//                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2Login()
                .successHandler(oAuth2LoginSuccessHandler)
                .and().logout().logoutUrl("/logout").logoutSuccessUrl(loginPageUrl).permitAll();


        return http.build();
    }
}
