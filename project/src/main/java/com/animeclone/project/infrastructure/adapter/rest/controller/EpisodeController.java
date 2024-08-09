package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.usecases.EpisodeService;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import com.animeclone.project.infrastructure.adapter.utils.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HexFormat;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/episode")
public class EpisodeController {

    private final EpisodeService episodeService;

    @PostMapping("/registry/{animeId}")
    @ResponseStatus(HttpStatus.CREATED)
    private String registerAnime(@PathVariable Long animeId,@RequestBody RequestEpisodeDTO request) throws AnimeNotFoundException {
        return episodeService.register(animeId,request);
    }
    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    private List<ResponseEpisodeDTO> getAllEpisodes(){
        return episodeService.findall();
    }



}
