package com.animeclone.project.application.service;

import com.animeclone.project.application.mapper.EpisodeMapper;
import com.animeclone.project.application.usecases.EpisodeService;
import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.domain.port.EpisodePersistencePort;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {

    private final EpisodeMapper episodeMapper;
    private final EpisodePersistencePort episodePersistencePort;



    @Override
    public String register(Long animeId, RequestEpisodeDTO requestEpisodeDTO) throws AnimeNotFoundException {
        Episode episode = episodeMapper.DTOtoDomain(requestEpisodeDTO);
        String episodeToPersist = episodePersistencePort.register(animeId,episode);
        System.out.println(animeId+"de serviceimpl");
        return episodeToPersist;

    }

    @Override
    public List<ResponseEpisodeDTO> findall() {
        var responseList=episodeMapper.toEpisodeResponseList(episodePersistencePort.findall());
        return responseList;

    }

    @Override
    public List<ResponseEpisodeDTO> findallByAnimeId(long animeId) {
        return List.of();
    }



    @Override
    public ResponseEpisodeDTO edit(Long id,RequestEpisodeDTO requestEpisodeDTO) {
        return null;
    }

    @Override
    public void delete(RequestEpisodeDTO requestEpisodeDTO) {

    }

    @Override
    public ResponseEpisodeDTO findbyid(Long id) {
        return null;
    }
}
