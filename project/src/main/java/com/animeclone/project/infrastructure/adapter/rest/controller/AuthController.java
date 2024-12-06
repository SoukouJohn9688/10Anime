package com.animeclone.project.infrastructure.adapter.rest.controller;

import com.animeclone.project.infrastructure.adapter.auth.AuthResponseDTO;
import com.animeclone.project.infrastructure.adapter.auth.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AuthController {
    @Autowired
    JwtService jwtService;


    @GetMapping("/token.grant")
    public AuthResponseDTO tokenGrant(@AuthenticationPrincipal OAuth2User principal) {
        Map<String,String> token=jwtService.getToken(principal);
        AuthResponseDTO response=new AuthResponseDTO();
        response.setAccessToken(token.get("token"));
        return response ;
    }


    @GetMapping("/home")
    public String testHome(){
        return "Hello Weabooo!!!";
    }



}