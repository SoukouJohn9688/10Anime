package com.animeclone.project.infrastructure.adapter.rest.controller;

import com.animeclone.project.infrastructure.adapter.auth.AuthResponseDTO;
import com.animeclone.project.infrastructure.adapter.auth.AuthService;
import com.animeclone.project.infrastructure.adapter.auth.LoginDTO;
import com.animeclone.project.infrastructure.adapter.auth.RegisterDTO;
import com.animeclone.project.infrastructure.adapter.exception.authexceptions.EmailExistsException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/api/v1/auth")
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
    public String login() {
        return "login.html";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

}