package com.animeclone.project.infrastructure.adapter.auth;


import com.animeclone.project.infrastructure.adapter.config.JwtService;
import com.animeclone.project.infrastructure.adapter.exception.authexceptions.OperationNotPermittedException;
import com.animeclone.project.infrastructure.adapter.role.RoleRepository;
import com.animeclone.project.infrastructure.adapter.user.UserEntity;
import com.animeclone.project.infrastructure.adapter.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public void register(RegistrationRequest request) {
        UserEntity userEntity = userRepository.findByEmail(request.getEmail()).orElse(null);
        if( userEntity != null){
            throw new OperationNotPermittedException("Email already registered!");
        }

        var userRole = roleRepository.findByName(request.getRole())
                .orElse(null);
        if(userRole == null){
            userRole = roleRepository.findByName("ROLE_USER")
                    .orElseThrow(() -> new IllegalStateException("ROLE USER was not initiated"));
        }


        var user = UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountLocked(false)
                .enabled(false)// Set enabled to true since we are removing email activation
                .active(false)
                .roles(List.of(userRole))
                .build();
        userRepository.save(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var claims = new HashMap<String, Object>();
        var user = ((UserEntity) auth.getPrincipal());
        System.out.println("user: "+user);
        claims.put("email", user.getEmail());

        var jwtToken = jwtService.generateToken(claims, user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
