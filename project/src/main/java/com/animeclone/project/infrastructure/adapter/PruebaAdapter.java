package com.animeclone.project.infrastructure.adapter;

import com.animeclone.project.domain.model.Genre;
import com.animeclone.project.infrastructure.adapter.mapper.GenreDboMapper;
import com.animeclone.project.infrastructure.adapter.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PruebaAdapter {

    private final GenreRepository genreRepository;
    private final GenreDboMapper genreDboMapper;

    public List<Genre> getAll() {


        return genreDboMapper.mapToGenres(genreRepository.findAll());
    }
}
