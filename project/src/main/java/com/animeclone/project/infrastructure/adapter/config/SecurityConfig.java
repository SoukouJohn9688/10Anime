package com.animeclone.project.infrastructure.adapter.config;

import com.nimbusds.jose.shaded.gson.internal.LinkedTreeMap;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/**").fullyAuthenticated();
                })
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverterForKeycloak() {
        Converter<Jwt, Collection<GrantedAuthority>> jwtGrantedAuthoritiesConverter = jwt -> {
            Map<String, Object> resourceAccess = jwt.getClaim("resource_access");

            Object client = resourceAccess.get("10Anime-client-api");

            LinkedTreeMap<String, List<String>> clientRoleMap = (LinkedTreeMap<String, List<String>>) client;
            System.out.println("clientRoleMap = " + clientRoleMap);

            List<String> clientRoles = new ArrayList<>(clientRoleMap.get("roles"));

            return clientRoles.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        };

        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();

        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

        return jwtAuthenticationConverter;
    }







//    @Autowired
//    private final JwtAuthenticationConverter jwtAuthenticationConverter;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(http -> {
//                    http.requestMatchers(HttpMethod.GET, "/", "/api/v1/home").permitAll();
//                    http.anyRequest().authenticated();
//                })
////                .oauth2Login(oauth2login -> oauth2login.successHandler(request, response, authentication) -> response.sendRedirect("/api/v1/home")))
//                .oauth2ResourceServer(oauth -> {
//                    oauth.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter));
//                })
//
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .build();
//    }




}
