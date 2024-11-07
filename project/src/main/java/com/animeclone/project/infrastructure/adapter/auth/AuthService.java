package com.animeclone.project.infrastructure.adapter.auth;

import com.animeclone.project.infrastructure.adapter.exception.authexceptions.EmailExistsException;

import java.security.Principal;

public interface AuthService {
    AuthResponseDTO login(LoginDTO request);
    AuthResponseDTO register(RegisterDTO request) throws EmailExistsException;
    AuthResponseDTO generateToken(Principal principal);
}