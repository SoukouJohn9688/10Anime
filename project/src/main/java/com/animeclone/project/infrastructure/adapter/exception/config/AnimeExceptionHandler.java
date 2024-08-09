package com.animeclone.project.infrastructure.adapter.exception.config;

import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeAlreadyExistException;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AnimeExceptionHandler {


    @ExceptionHandler(AnimeNotFoundException.class)
    public ResponseEntity<Map<String, String>> Animenotfound(AnimeNotFoundException ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("Anime_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(AnimeAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleAnimeAlreadyExists(AnimeAlreadyExistException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Anime_ERROR", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
