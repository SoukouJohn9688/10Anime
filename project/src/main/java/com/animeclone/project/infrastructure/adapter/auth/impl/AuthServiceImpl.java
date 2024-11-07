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

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDTO login(LoginDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found")); // Manejo de excepción mejorado

        String token = jwtService.getToken(user);

        return AuthResponseDTO.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .build();
    }

    @Override
    public AuthResponseDTO register(RegisterDTO request) throws EmailExistsException {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
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

    @Override
    public AuthResponseDTO generateToken(Principal principal) {
        String email = principal.getName();
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.getToken(user);

        return AuthResponseDTO.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .build();
    }


}
