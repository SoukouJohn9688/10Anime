package com.animeclone.project.infrastructure.adapter.auth;

import com.animeclone.project.infrastructure.adapter.exception.authexceptions.UsernameNotFoundException;
import com.animeclone.project.infrastructure.adapter.user.UserEntity;
import com.animeclone.project.infrastructure.adapter.user.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest request) {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody @Valid AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/test")
    public ResponseEntity<?> testPasswordEncoding(@RequestBody AuthenticationRequest request) {
        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        boolean matches = passwordEncoder.matches(request.getPassword(), user.getPassword());
        return ResponseEntity.ok(matches ? "Passwords match" : "Passwords do not match");
    }

}
