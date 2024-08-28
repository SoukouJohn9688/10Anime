package com.animeclone.project.infrastructure.adapter.rest.controller;

import com.animeclone.project.application.usecases.GenreService;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private ResponseEntity<List<ResponseGenreDTO>> getAll(){

        return ResponseEntity.status(HttpStatus.OK)
                .body(genreService.getGenres());

    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        genreService.deleteById(id);

    }
    @PostMapping("{id}")
    private ResponseGenreDTO edit(@PathVariable Long id, @RequestBody RequestGenreDTO request) throws GenreNotFoundException {
        return genreService.edit(id,request);
    }

}
