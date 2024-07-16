package com.animeclone.project.application.service;

import com.animeclone.project.application.mapper.GenreMapper;
import com.animeclone.project.application.usecases.GenreService;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import com.animeclone.project.domain.port.GenrePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreMapper genreMapper;
    private final GenrePersistencePort genrePersistencePort;


    @Override
    public ResponseGenreDTO registerGenre(RequestGenreDTO request) {
        Genre convertDomain=genreMapper.DTOtoDomain(request);
        Genre registeredGenre=genrePersistencePort.create(convertDomain);
        return genreMapper.DomainToResponse(registeredGenre);
    }

}