package com.animeclone.project.application.usecases;

import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;

public interface GenreService {
    ResponseGenreDTO registerGenre(RequestGenreDTO request);

}
