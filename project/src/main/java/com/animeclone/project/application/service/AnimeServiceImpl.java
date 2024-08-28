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
    public List<ResponseAnimeDTO> findByName(String name) {
       List<Anime> updatedAnime=animePersistencePort.findByName(name);
        return animeMapper.toAnimeResponseList(updatedAnime);

    }

    @Override
    public List<ResponseAnimeDTO> findByGenreName(String genreName) {
        List<Anime> list=animePersistencePort.findByGenreName(genreName);
        return animeMapper.toAnimeResponseList(list) ;
    }

    @Override
    public List<ResponseAnimeDTO> findByType(String type) {
        return animeMapper.toAnimeResponseList(animePersistencePort.findByType(type));
    }

    @Override
    public List<ResponseAnimeDTO> findByYear(int year) throws AnimeNotFoundException {

        return animeMapper.toAnimeResponseList(animePersistencePort.findByYear(year));
    }

    @Override
    public ResponseAnimeDTO getRandomAnime() {
        return animeMapper.DomainToResponse(animePersistencePort.getRandomAnime());
    }

    @Override
    public List<ResponseAnimeDTO> listTopAnimeToday() {
        return animeMapper.toAnimeResponseList(animePersistencePort.getTopToday());
    }

    @Override
    public List<ResponseAnimeDTO> listTopAnimeWeek() {
        return animeMapper.toAnimeResponseList(animePersistencePort.getTopWeek());
    }

    @Override
    public List<ResponseAnimeDTO> listTopAnimeMonth() {
        return animeMapper.toAnimeResponseList(animePersistencePort.getTopMonth());
    }


}
