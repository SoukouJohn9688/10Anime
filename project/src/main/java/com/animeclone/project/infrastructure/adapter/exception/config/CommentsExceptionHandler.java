package com.animeclone.project.infrastructure.adapter.exception.config;

import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeAlreadyExistException;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.comments.CommentsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CommentsExceptionHandler {


    @ExceptionHandler(CommentsNotFoundException.class)
    public ResponseEntity<Map<String, String>> Commentsnotfound(CommentsNotFoundException ex) {
        Map<String, String> resp = new HashMap<>();
        resp.put("Comments_ERROR", ex.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }

}
