package com.animeclone.project.infrastructure.adapter.exception.authexceptions;

public class OperationNotPermittedException extends RuntimeException{
    public OperationNotPermittedException(String message) {
        super(message);
    }
}
