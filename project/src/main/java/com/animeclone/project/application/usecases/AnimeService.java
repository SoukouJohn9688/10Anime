package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.AnimeDTO;

import java.util.List;

public interface AnimeService {


    AnimeDTO registerAnime();
    AnimeDTO getById(Long id);
    List<AnimeDTO> getAllById(Long id);
    AnimeDTO updateAnimeById(Long id, AnimeDTO request);
    AnimeDTO deleteAnime(Long Id);
}
