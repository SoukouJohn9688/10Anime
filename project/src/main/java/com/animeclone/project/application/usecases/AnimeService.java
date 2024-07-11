package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;

import java.util.List;

public interface AnimeService {


    RequestAnimeDTO registerAnime();
    RequestAnimeDTO getById(Long id);
    List<RequestAnimeDTO> getAllById(Long id);
    RequestAnimeDTO updateAnimeById(Long id, RequestAnimeDTO request);
    RequestAnimeDTO deleteAnime(Long Id);
}
