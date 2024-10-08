package com.animeclone.project.infrastructure.adapter.auth.impl;

import com.animeclone.project.infrastructure.adapter.auth.AuthResponseDTO;
import com.animeclone.project.infrastructure.adapter.auth.AuthService;
import com.animeclone.project.infrastructure.adapter.auth.LoginDTO;
import com.animeclone.project.infrastructure.adapter.auth.RegisterDTO;
import com.animeclone.project.infrastructure.adapter.config.jwt.service.JwtService;
import com.animeclone.project.infrastructure.adapter.exception.authexceptions.EmailExistsException;
import com.animeclone.project.infrastructure.adapter.role.RoleEnum;
import com.animeclone.project.infrastructure.adapter.user.UserEntity;
import com.animeclone.project.infrastructure.adapter.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponseDTO login(LoginDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        UserDetails user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponseDTO.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .build();
    }

    public AuthResponseDTO register(RegisterDTO request) throws EmailExistsException {
        Optional<UserEntity> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isPresent()) {
            throw new EmailExistsException("Ya existe un usuario con ese email");
        }

        UserEntity user = UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .username(request.getUsername())
                .roles(RoleEnum.valueOf(request.getRole().toUpperCase()))
                .build();
        userRepository.save(user);



        return AuthResponseDTO.builder()
                .accessToken(jwtService.getToken(user))
                .tokenType("Bearer")
                .build();
    }
}