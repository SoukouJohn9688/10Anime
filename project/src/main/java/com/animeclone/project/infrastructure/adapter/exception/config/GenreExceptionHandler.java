package com.animeclone.project.infrastructure.adapter.exception.config;

import com.animeclone.project.infrastructure.adapter.exception.genre.GenreAlreadyExistException;
import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GenreExceptionHandler {

    @ExceptionHandler(GenreNotFoundException.class)
    public ResponseEntity<Map<String, String>> Genrenotfound(GenreNotFoundException ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("Genre_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GenreAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleGenreAlreadyExists( GenreAlreadyExistException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Episode_ERROR", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
