package com.animeclone.project.infrastructure.adapter.rest.controller;

import com.animeclone.project.application.usecases.GenreService;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    private final GenreService genreService;

    @PostMapping("/registry")
    private ResponseGenreDTO registerGenre(@RequestBody RequestGenreDTO request){

        return genreService.registerGenre(request);
    }

    @GetMapping
    private ResponseEntity<Set<ResponseGenreDTO>> getAll(){

        return ResponseEntity.status(HttpStatus.OK)
                .body(genreService.getGenres());

    }

}
