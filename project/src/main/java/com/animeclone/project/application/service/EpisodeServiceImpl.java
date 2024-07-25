package com.animeclone.project.application.service;

import com.animeclone.project.application.mapper.EpisodeMapper;
import com.animeclone.project.application.usecases.EpisodeService;
import com.animeclone.project.domain.model.Episode;
import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.domain.port.EpisodePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {

    private final EpisodeMapper episodeMapper;
    private final EpisodePersistencePort episodePersistencePort;



    @Override
    public ResponseEpisodeDTO register(RequestEpisodeDTO requestEpisodeDTO) {
        Episode episode = episodeMapper.DTOtoDomain(requestEpisodeDTO);
        Episode episodeToPersist = episodePersistencePort.register(episode);
        return episodeMapper.DomainToResponse(episodeToPersist);
    }

    @Override
    public List<ResponseEpisodeDTO> findall() {
        return List.of();
    }

    @Override
    public ResponseEpisodeDTO edit(RequestEpisodeDTO requestEpisodeDTO) {
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
