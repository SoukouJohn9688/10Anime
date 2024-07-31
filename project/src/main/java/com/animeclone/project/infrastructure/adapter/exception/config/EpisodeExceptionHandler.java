package com.animeclone.project.infrastructure.adapter.exception.config;

import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeAlreadyExistException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeAlreadyExistException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class EpisodeExceptionHandler {

    @ExceptionHandler(EpisodeNotFoundException.class)
    public ResponseEntity<Map<String, String>> Episodenotfound(EpisodeNotFoundException ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("Episode_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EpisodeAlreadyExistException.class)
    public ResponseEntity<Map<String, String>> handleEpisodeAlreadyExists(EpisodeAlreadyExistException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Episode_ERROR", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}


