package com.animeclone.project.infrastructure.adapter.rest.advice;

import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeBadRequestException;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GeneralControllerAdvice {
    @ExceptionHandler(value = AnimeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public AnimeNotFoundException handlerAnimeNotFoundException(AnimeNotFoundException ex) {
        return new AnimeNotFoundException(ex.getMessage());
    }

    @ExceptionHandler(value = AnimeBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public AnimeBadRequestException handlerAnimeBadRequestException(AnimeBadRequestException ex) {
        return new AnimeBadRequestException(ex.getMessage());
    }





}
