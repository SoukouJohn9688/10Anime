package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.episode.RequestEpisodeDTO;
import com.animeclone.project.domain.model.dto.episode.ResponseEpisodeDTO;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import com.animeclone.project.infrastructure.adapter.exception.episode.EpisodeNotFoundException;
import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;

import java.util.Set;

public interface GenreService {
    ResponseGenreDTO registerGenre(RequestGenreDTO request);
    Set<ResponseGenreDTO> getGenres();
    ResponseGenreDTO edit(Long id, RequestGenreDTO request) throws GenreNotFoundException;
}
