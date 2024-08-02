package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import com.animeclone.project.infrastructure.adapter.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/anime")
public class AnimeController {

    @Autowired
    private AnimeService animeService;



    @PostMapping("/registry")
    private ResponseAnimeDTO registerAnime(@Validated @RequestBody RequestAnimeDTO request){

        return animeService.registerAnime(request);
    }
//    @PostMapping("/edit/{animeId}")
//    @ResponseStatus(HttpStatus.OK)
//    private ResponseEntity<Response> editAnime(@PathVariable long animeId
//            , @Validated @RequestBody RequestAnimeDTO requestAnimeDTO) throws AnimeNotFoundException {
//        ResponseAnimeDTO updatedAnime=animeService.updateAnimeById(animeId,requestAnimeDTO);
//        Response response=new Response(true,HttpStatus.OK, updatedAnime);
//        return ResponseEntity.ok(response);
//
//    }
    @PostMapping("/edit/{animeId}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseAnimeDTO editAnime(@PathVariable long animeId
            , @Validated @RequestBody RequestAnimeDTO requestAnimeDTO) throws AnimeNotFoundException {

        ResponseAnimeDTO updatedAnime=animeService.updateAnimeById(animeId,requestAnimeDTO);
        return updatedAnime;

    }
    @GetMapping("/find")
    private List<ResponseAnimeDTO> getAllAnimes(){
        return animeService.getAll();
    }

}
