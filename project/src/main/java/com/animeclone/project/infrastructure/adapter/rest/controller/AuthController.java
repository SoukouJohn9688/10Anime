package com.animeclone.project.infrastructure.adapter.rest.controller;

import com.animeclone.project.infrastructure.adapter.auth.AuthResponseDTO;
import com.animeclone.project.infrastructure.adapter.auth.AuthService;
import com.animeclone.project.infrastructure.adapter.auth.LoginDTO;
import com.animeclone.project.infrastructure.adapter.auth.RegisterDTO;
import com.animeclone.project.infrastructure.adapter.exception.authexceptions.EmailExistsException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

//    @PostMapping("/login")
//    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO request) {
//        return ResponseEntity.ok(authService.login(request));
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<AuthResponseDTO> register(@RequestBody @Valid RegisterDTO request) throws EmailExistsException {
//        return ResponseEntity.ok(authService.register(request));
//    }


    @GetMapping("/login")
    public void login(HttpServletResponse response) throws IOException {
        response.sendRedirect("/oauth2/authorization/google");
    }

    @GetMapping("/token")
    public ResponseEntity<AuthResponseDTO> getToken(Principal principal) {
        AuthResponseDTO response = authService.generateToken(principal);
        return ResponseEntity.ok(response);
    }



}