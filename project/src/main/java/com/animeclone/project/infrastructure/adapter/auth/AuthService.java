package com.animeclone.project.infrastructure.adapter.auth;

import com.animeclone.project.infrastructure.adapter.exception.authexceptions.EmailExistsException;

public interface AuthService {
    AuthResponseDTO login(LoginDTO request);
    AuthResponseDTO register(RegisterDTO request) throws EmailExistsException;
}