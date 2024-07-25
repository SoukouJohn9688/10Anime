package com.animeclone.project.application.usecases;


import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;

import java.util.List;

public interface EpisodeService {

    ResponseEpisodeDTO register(RequestEpisodeDTO requestEpisodeDTO);

    List<ResponseEpisodeDTO> findall();

    ResponseEpisodeDTO edit(RequestEpisodeDTO requestEpisodeDTO);

    void delete(RequestEpisodeDTO requestEpisodeDTO);

    ResponseEpisodeDTO findbyid(Long id);




}
