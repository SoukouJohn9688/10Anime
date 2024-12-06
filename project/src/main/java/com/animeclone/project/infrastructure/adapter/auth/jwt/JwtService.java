package com.animeclone.project.infrastructure.adapter.auth.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class JwtService {

    @Autowired
    private JwtUtil jwtUtil;



    public Map<String, String> getToken(@AuthenticationPrincipal OAuth2User principal) {
        System.out.println(principal);

        // Extract user information from the principal
        String username = principal.getAttribute("name");
        String email = principal.getAttribute("email");

        // Create claims for the JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("email", email);

        // Generate JWT
        String token = jwtUtil.generateToken(email, claims);


        // Return token and user information
        Map<String, String> response = new HashMap<>();
        response.put("username", username);
        response.put("email", email);
        response.put("token", token);

        System.out.println("response = " + response);
        return response;
    }


}
