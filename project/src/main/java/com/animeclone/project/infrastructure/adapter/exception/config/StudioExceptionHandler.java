package com.animeclone.project.infrastructure.adapter.exception.config;

import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.studio.StudioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class StudioExceptionHandler {

    @ExceptionHandler(StudioNotFoundException.class)
    public ResponseEntity<Map<String, String>> StudioNotFound(StudioNotFoundException ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("Studio_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }


}
