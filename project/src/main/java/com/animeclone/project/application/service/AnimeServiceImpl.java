package com.animeclone.project.application.service;

import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.dto.AnimeDTO;

import java.util.List;

public class AnimeServiceImpl implements AnimeService {


    @Override
    public AnimeDTO registerAnime() {
        return null;
    }

    @Override
    public AnimeDTO getById(Long id) {
        return null;
    }

    @Override
    public List<AnimeDTO> getAllById(Long id) {
        return List.of();
    }

    @Override
    public AnimeDTO updateAnimeById(Long id, AnimeDTO request) {
        return null;
    }

    @Override
    public AnimeDTO deleteAnime(Long Id) {
        return null;
    }
}
