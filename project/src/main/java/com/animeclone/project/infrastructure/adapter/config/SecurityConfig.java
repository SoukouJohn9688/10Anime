package com.animeclone.project.infrastructure.adapter.config;


import com.animeclone.project.infrastructure.adapter.auth.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
public class SecurityConfig {


    @Autowired
    JwtTokenFilter jwtTokenFilter;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.addAllowedOrigin("http://localhost:3000");
                    config.addAllowedMethod("*");
                    config.addAllowedHeader("*");
                    config.setAllowCredentials(true);
                    return config;
                }))
                .csrf(csrf -> csrf.ignoringRequestMatchers("/ws/**"))
                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/").permitAll();
                    registry.requestMatchers("/ws/**").permitAll();
                    registry.requestMatchers("/colors").permitAll();
                    registry.requestMatchers("/api/v1/auth").permitAll();
                    registry.anyRequest().authenticated();
                })
                .formLogin().disable()
                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true))

                .logout(logout -> logout
                        .logoutSuccessUrl("/")
                        .permitAll())
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class); // Add the custom filter
        ;

        return http.build();
    }

}
