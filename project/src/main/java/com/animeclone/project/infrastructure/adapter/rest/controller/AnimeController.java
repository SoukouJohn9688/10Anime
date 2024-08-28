package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/find/byyear/{year}")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getAnimeByYear(@PathVariable int year) throws AnimeNotFoundException {
        return animeService.findByYear(year);
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

   @GetMapping("/find/toptoday")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getTopToday(){
        return animeService.listTopAnimeToday();
    }

    @GetMapping("/find/topweek")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getTopWeek(){
        return animeService.listTopAnimeWeek();
    }

    @GetMapping("/find/topmonth")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseAnimeDTO> getTopMonth(){
        return animeService.listTopAnimeMonth();
    }

  @GetMapping("/find/random")
  @ResponseStatus(HttpStatus.OK)
    private ResponseAnimeDTO getRandomAnime(){
        return animeService.getRandomAnime();
    }






}
