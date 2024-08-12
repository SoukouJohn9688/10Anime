package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import com.animeclone.project.infrastructure.adapter.utils.Response;
import jakarta.validation.Valid;
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
    @ResponseStatus(HttpStatus.OK)
    private ResponseAnimeDTO registerAnime(@Valid @RequestBody RequestAnimeDTO request){
        return animeService.registerAnime(request);
    }

    @PostMapping("/edit/{animeId}")
    @ResponseStatus(HttpStatus.OK)
    private ResponseAnimeDTO editAnime(@PathVariable long animeId
            , @Validated @RequestBody RequestAnimeDTO requestAnimeDTO) throws AnimeNotFoundException {

        ResponseAnimeDTO updatedAnime=animeService.updateAnimeById(animeId,requestAnimeDTO);
        return updatedAnime;

    }
    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getAllAnimes(){
        return animeService.getAll();
    }


    @GetMapping("/find/{animeName}")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getAnimeByName(@PathVariable String animeName){
        return animeService.findByName(animeName);
    }

    @GetMapping("/find/bygenre/{animeGenre}")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getAnimeByGenreName(@PathVariable String animeGenre){
        return animeService.findByGenreName(animeGenre);
    }

    @GetMapping("/find/bytype/{animeType}")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getAnimeByType(@PathVariable String animeType){
        return animeService.findByType(animeType);
    }


  @GetMapping("/find/random")
  @ResponseStatus(HttpStatus.OK)
    private ResponseAnimeDTO getRandomAnime(){
        return animeService.getRandomAnime();
    }

    @GetMapping("/find/desc")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> findAllByOrderByDateAiredDesc(){
        return animeService.findAllByOrderByDateAiredDesc();
    }

    @GetMapping("/find/bystatus/{animeStatus}")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getAnimeByStatus(@PathVariable String animeStatus){
        return animeService.findByStatus(animeStatus);
    }

    @GetMapping("/find/bydubbed/{dubbed}")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getAnimeByDubbed(@PathVariable String dubbed){
        return animeService.findByDubbed(dubbed);
    }

    @GetMapping("/find/bystatusdesc")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getAnimeByStatusDesc(){
        return animeService.findByStatusDesc();
    }




}
