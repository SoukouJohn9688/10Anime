package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;

import java.util.List;


public interface AnimeService {


    ResponseAnimeDTO registerAnime(RequestAnimeDTO request);
    ResponseAnimeDTO getById(Long id);
    List<ResponseAnimeDTO> getAll();
    ResponseAnimeDTO updateAnimeById(Long id, RequestAnimeDTO request) throws AnimeNotFoundException;
    ResponseAnimeDTO deleteAnime(Long Id);
    ResponseEpisodeDTO addEpisodeToAnime(Long animeId, RequestEpisodeDTO requestEpisodeDTO);
    ResponseEpisodeDTO addGenreToAnime(Long animeId, RequestGenreDTO requestGenreDTO);

    List<ResponseAnimeDTO> findByName(String name);
    List<ResponseAnimeDTO> findByGenreName(String genreName);
    List<ResponseAnimeDTO> findByType(String type);
    List<ResponseAnimeDTO> findByYear(int year) throws AnimeNotFoundException;

    ResponseAnimeDTO getRandomAnime();

    List<ResponseAnimeDTO> listTopAnimeToday();
    List<ResponseAnimeDTO> listTopAnimeWeek();
    List<ResponseAnimeDTO> listTopAnimeMonth();




}
