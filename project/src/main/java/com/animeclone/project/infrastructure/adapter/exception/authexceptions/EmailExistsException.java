package com.animeclone.project.infrastructure.adapter.exception.authexceptions;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(String message) {
        super(message);
    }
}
