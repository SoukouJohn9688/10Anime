package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;

import java.util.Set;

public interface GenreService {
    ResponseGenreDTO registerGenre(RequestGenreDTO request);
    Set<ResponseGenreDTO> getGenres();

}
