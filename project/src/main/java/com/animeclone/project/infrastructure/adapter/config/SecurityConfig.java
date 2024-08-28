package com.animeclone.project.infrastructure.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(request -> {
                    request.requestMatchers(HttpMethod.GET, "/", "/api/v1/home").permitAll();
                    request.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .oauth2Login(oauth2login -> oauth2login.defaultSuccessUrl("/api/v1/home", true))


//                .oauth2Login(oauth2login -> oauth2login.successHandler(
//                        (request, response, authentication) -> response.sendRedirect("/api/v1/home")))
                .build();
    }
}
