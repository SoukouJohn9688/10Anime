package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;

import java.util.List;


public interface AnimeService {


    ResponseAnimeDTO registerAnime(RequestAnimeDTO request);
    RequestAnimeDTO getById(Long id);
    List<RequestAnimeDTO> getAllById(Long id);
    RequestAnimeDTO updateAnimeById(Long id, RequestAnimeDTO request);
    RequestAnimeDTO deleteAnime(Long Id);
}
