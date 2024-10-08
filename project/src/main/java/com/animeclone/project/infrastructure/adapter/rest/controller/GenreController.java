package com.animeclone.project.infrastructure.adapter.rest.controller;

import com.animeclone.project.application.usecases.GenreService;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import com.animeclone.project.infrastructure.adapter.PruebaAdapter;
import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/v1/genre")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;
    private final PruebaAdapter pruebaAdapter;




    @GetMapping("/test")
    //@PreAuthorize("hasAnyRole('ADMIN','USER')")
    @Secured({"ADMIN","USER"})
    public String testisimo() {
        List<Genre> listadev = pruebaAdapter.getAll();
        return "tonto el que lo lea";
    }
    
    @PostMapping("/registry")
    @Secured({"ADMIN","USER"})
    private ResponseGenreDTO registerGenre(@RequestBody RequestGenreDTO request){

        return genreService.registerGenre(request);
    }

    @GetMapping
    private ResponseEntity<List<ResponseGenreDTO>> getAll(){

            System.out.println("genreService.getGenres() = " + genreService.getGenres());


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
