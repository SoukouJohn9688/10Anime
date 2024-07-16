package com.animeclone.project.application.service;

import com.animeclone.project.application.mapper.AnimeMapper;
import com.animeclone.project.application.usecases.AnimeService;
import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.dto.anime.RequestAnimeDTO;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.port.AnimePersistencePort;
import com.animeclone.project.infrastructure.adapter.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
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
