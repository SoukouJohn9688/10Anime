package com.animeclone.project.application.service;

import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;

import java.util.List;

public class AnimeServiceImpl implements AnimeService {


    @Override
    public RequestAnimeDTO registerAnime() {
        return null;
    }

    @Override
    public RequestAnimeDTO getById(Long id) {
        return null;
    }

    @Override
    public List<RequestAnimeDTO> getAllById(Long id) {
        return List.of();
    }

    @Override
    public RequestAnimeDTO updateAnimeById(Long id, RequestAnimeDTO request) {
        return null;
    }

    @Override
    public RequestAnimeDTO deleteAnime(Long Id) {
        return null;
    }
}
