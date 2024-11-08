package com.animeclone.project.infrastructure.adapter.auth.impl;

import com.animeclone.project.infrastructure.adapter.auth.AuthResponseDTO;
import com.animeclone.project.infrastructure.adapter.auth.AuthService;
import com.animeclone.project.infrastructure.adapter.auth.LoginDTO;
import com.animeclone.project.infrastructure.adapter.auth.RegisterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Override
    public AuthResponseDTO login(LoginDTO request) {
        throw new UnsupportedOperationException("Login manual no soportado con Google OAuth2");
    }

    @Override
    public AuthResponseDTO register(RegisterDTO request) {
        throw new UnsupportedOperationException("Registro manual no soportado con Google OAuth2");
    }

    @Override
    public AuthResponseDTO generateToken(Principal principal) {
        if (!(principal instanceof OAuth2AuthenticationToken)) {
            throw new RuntimeException("Autenticación OAuth2 no encontrada");
        }

        // Se extrae la información del usuario autenticado a través de Google OAuth2
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) principal;
        String email = oauthToken.getPrincipal().getAttribute("email");
        String name = oauthToken.getPrincipal().getAttribute("name");

        // Retorna la respuesta con la información básica, sin un token adicional
        return AuthResponseDTO.builder()
                .accessToken(null)  // No se emite un token propio
                .tokenType("Google OAuth2")  // Se indica el tipo de autenticación usada
                .build();
    }
}
