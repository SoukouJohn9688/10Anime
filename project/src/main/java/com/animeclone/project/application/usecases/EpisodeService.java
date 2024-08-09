package com.animeclone.project.application.usecases;


import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;

import java.util.List;

public interface EpisodeService {

    String register(Long animeId, RequestEpisodeDTO requestEpisodeDTO) throws AnimeNotFoundException;

    List<ResponseEpisodeDTO> findall();
    List<ResponseEpisodeDTO> findallByAnimeId(long animeId);


    ResponseEpisodeDTO edit(Long id,RequestEpisodeDTO requestEpisodeDTO) throws EpisodeNotFoundException;

    void delete(RequestEpisodeDTO requestEpisodeDTO);

    ResponseEpisodeDTO findbyid(Long id);




}
