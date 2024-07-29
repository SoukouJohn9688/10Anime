package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.usecases.EpisodeService;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/episode")
public class EpisodeController {

    private final EpisodeService episodeService;

    @PostMapping("/registry/{animeId}")
    private ResponseEpisodeDTO registerAnime(@PathVariable Long animeId,@RequestBody RequestEpisodeDTO request){
        System.out.println(animeId);
        return episodeService.register(animeId,request);
    }



}
