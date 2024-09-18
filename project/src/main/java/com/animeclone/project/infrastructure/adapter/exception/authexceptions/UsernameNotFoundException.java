package com.animeclone.project.infrastructure.adapter.exception.authexceptions;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException(String message) {
        super(message);
    }
}
