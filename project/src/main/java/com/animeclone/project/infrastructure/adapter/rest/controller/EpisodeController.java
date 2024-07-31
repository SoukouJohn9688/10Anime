package com.animeclone.project.infrastructure.adapter.rest.controller;


import com.animeclone.project.application.usecases.EpisodeService;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/episode")
public class EpisodeController {

    private final EpisodeService episodeService;

    @PostMapping("/registry/{animeId}")
    private ResponseEpisodeDTO registerAnime(@PathVariable Long animeId,@RequestBody RequestEpisodeDTO request){
        return episodeService.register(animeId,request);
    }
    @GetMapping("/find")
    private List<ResponseEpisodeDTO> getAllAnimes(){
        return episodeService.findall();
    }

    @PostMapping("{id}")
    private ResponseEpisodeDTO edit(@PathVariable Long id, @RequestBody RequestEpisodeDTO request) throws EpisodeNotFoundException {
        return episodeService.edit(id,request);
    }
}
