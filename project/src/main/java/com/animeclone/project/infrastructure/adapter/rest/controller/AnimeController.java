package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;


    @GetMapping
    private String cargarLista(){
        return "Probandooooooooo";
    }



    @PostMapping("/registry")
    private ResponseAnimeDTO registerAnime(@RequestBody RequestAnimeDTO request){

        return animeService.registerAnime(request);
    }

}
