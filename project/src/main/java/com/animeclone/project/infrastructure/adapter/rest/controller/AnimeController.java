package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;



    @PostMapping("/registry")
    private ResponseAnimeDTO registerAnime(@Validated @RequestBody RequestAnimeDTO request){

        return animeService.registerAnime(request);
    }

    @GetMapping("/find")
    private List<ResponseAnimeDTO> getAllAnimes(){
        return animeService.getAll();
    }

}
