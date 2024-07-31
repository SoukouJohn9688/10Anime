package com.animeclone.project.application.service;

import com.animeclone.project.application.mapper.EpisodeMapper;
import com.animeclone.project.application.usecases.EpisodeService;
import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.domain.port.EpisodePersistencePort;
import com.animeclone.project.infrastructure.adapter.entity.EpisodeEntity;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {

    private final EpisodeMapper episodeMapper;
    private final EpisodePersistencePort episodePersistencePort;



    @Override
    public ResponseEpisodeDTO register(Long animeId,RequestEpisodeDTO requestEpisodeDTO) {
        Episode episode = episodeMapper.DTOtoDomain(requestEpisodeDTO);
        Episode episodeToPersist = episodePersistencePort.register(animeId,episode);
        System.out.println(animeId+"de serviceimpl");
        return episodeMapper.DomainToResponse(episodeToPersist);

    }

    @Override
    public List<ResponseEpisodeDTO> findall() {
        var responseList=episodeMapper.toEpisodeResponseList(episodePersistencePort.findall());
        return responseList;

    }

    @Override
    public ResponseEpisodeDTO edit(Long id,RequestEpisodeDTO requestEpisodeDTO) throws EpisodeNotFoundException {
        Episode episode = episodeMapper.DTOtoDomain(requestEpisodeDTO);
        Episode episodeToPersist = episodePersistencePort.edit(id,episode);
        return episodeMapper.DomainToResponse(episodeToPersist);

     }

    @Override
    public void delete(RequestEpisodeDTO requestEpisodeDTO) {

    }

    @Override
    public ResponseEpisodeDTO findbyid(Long id) {
        return null;
    }
}
