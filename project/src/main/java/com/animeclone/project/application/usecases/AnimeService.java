package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;

import java.util.List;


public interface AnimeService {


    ResponseAnimeDTO registerAnime(RequestAnimeDTO request);
    RequestAnimeDTO getById(Long id);
    List<ResponseAnimeDTO> getAll();
    RequestAnimeDTO updateAnimeById(Long id, RequestAnimeDTO request);
    RequestAnimeDTO deleteAnime(Long Id);
    ResponseEpisodeDTO addEpisodeToAnime(Long animeId, RequestEpisodeDTO requestEpisodeDTO);
    ResponseEpisodeDTO addGenreToAnime(Long animeId, RequestGenreDTO requestGenreDTO);
}
