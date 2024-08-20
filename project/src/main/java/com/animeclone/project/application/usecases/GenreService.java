package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;

import java.util.List;
import java.util.Set;

public interface GenreService {
    ResponseGenreDTO registerGenre(RequestGenreDTO request);
    List<ResponseGenreDTO> getGenres();
    ResponseGenreDTO edit(Long id, RequestGenreDTO request) throws GenreNotFoundException;
    void deleteById(Long id);
    List<ResponseGenreDTO> findByName(String name);
}
