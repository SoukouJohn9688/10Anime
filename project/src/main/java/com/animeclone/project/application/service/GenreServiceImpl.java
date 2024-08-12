package com.animeclone.project.application.service;

import com.animeclone.project.application.mapper.GenreMapper;
import com.animeclone.project.application.usecases.GenreService;
import com.animeclone.project.domain.model.Anime;
import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.domain.model.dto.anime.ResponseAnimeDTO;
import com.animeclone.project.domain.model.dto.genre.RequestGenreDTO;
import com.animeclone.project.domain.model.dto.genre.ResponseGenreDTO;
import com.animeclone.project.domain.port.GenrePersistencePort;
import com.animeclone.project.infrastructure.adapter.exception.genre.GenreNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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

    @Override
    public List<ResponseGenreDTO> getGenres() {


        return genreMapper.toGenresResponseList(genrePersistencePort.getAll());
    }

    @Override
    public ResponseGenreDTO edit(Long id, RequestGenreDTO request) throws GenreNotFoundException {
        Genre genre = genreMapper.DTOtoDomain(request);
        Genre genreToPersist = genrePersistencePort.edit(id, genre);
        return genreMapper.DomainToResponse(genreToPersist);

    }

    @Override
    public void deleteById(Long id) {
         genrePersistencePort.deleteById(id);

    }

    @Override
    public List<ResponseGenreDTO> findByName(String name) {
        List<Genre> updateGenre=genrePersistencePort.FindByName(name);
        return genreMapper.toGenresResponseList(updateGenre);

    }

}
