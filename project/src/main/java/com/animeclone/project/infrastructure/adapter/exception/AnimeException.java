package com.animeclone.project.infrastructure.adapter.exception;

import org.springframework.http.HttpStatus;

public class AnimeException extends RuntimeException{
    private HttpStatus errorCode;
    private String errorMessage;

    public AnimeException() {
    }

    public AnimeException(HttpStatus errorCode,String errorMessage ) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public HttpStatus getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(HttpStatus errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
