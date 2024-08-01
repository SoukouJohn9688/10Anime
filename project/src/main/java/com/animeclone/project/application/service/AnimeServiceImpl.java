package com.animeclone.project.application.service;

import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.infrastructure.adapter.exception.anime.AnimeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnimeServiceImpl implements AnimeService {


    private final AnimeMapper animeMapper;
    private final AnimePersistencePort animePersistencePort;


    @Override
    public ResponseAnimeDTO registerAnime(RequestAnimeDTO request) {
        Anime convertDomain=animeMapper.DTOtoDomain(request);
        Anime registeredAnime=animePersistencePort.create(convertDomain);
        return animeMapper.DomainToResponse(registeredAnime);
    }

    @Override
    public ResponseAnimeDTO getById(Long id) {
        return null;
    }

    @Override
    public List<ResponseAnimeDTO> getAll() {
        var responseList=animeMapper.toAnimeResponseList(animePersistencePort.getAll());
        return responseList;
    }

    @Override
    public ResponseAnimeDTO updateAnimeById(Long id, RequestAnimeDTO request) throws AnimeNotFoundException {
        Anime convertReqDomain=animeMapper.DTOtoDomain(request);
        Anime updatedAnime=animePersistencePort.update(id,convertReqDomain);
        return animeMapper.DomainToResponse(updatedAnime);
    }

    @Override
    public ResponseAnimeDTO deleteAnime(Long Id) {
        return null;
    }

    @Override
    public ResponseEpisodeDTO addEpisodeToAnime(Long animeId, RequestEpisodeDTO requestEpisodeDTO) {
        return null;
    }

    @Override
    public ResponseEpisodeDTO addGenreToAnime(Long animeId, RequestGenreDTO requestGenreDTO) {
        return null;
    }

    @Override
    public ResponseAnimeDTO findByName(String name) {
       Anime updatedAnime=animePersistencePort.FindByName(name);
        return animeMapper.DomainToResponse(updatedAnime);

    }
}
